package lk.ijse.malshanrentshopmanagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import lk.ijse.malshanrentshopmanagement.bo.BOFactory;
import lk.ijse.malshanrentshopmanagement.bo.custom.CustomerPaymentBO;
import lk.ijse.malshanrentshopmanagement.bo.custom.impl.CustomerPaymentBOImpl;
import lk.ijse.malshanrentshopmanagement.db.DBConnection;
import lk.ijse.malshanrentshopmanagement.dto.CustomerPaymentDto;
import lk.ijse.malshanrentshopmanagement.dto.tm.CustomerPaymentTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class ManageCustomerPaymentFormController implements Initializable {
    public AnchorPane AncCustomer;
    public JFXTextField txtCardNumber;
    public DatePicker txtRentalPeriod;
    public JFXComboBox<Integer> cmbVehicleId;
    public JFXComboBox<String> cmbpaymentMethod;
    public JFXComboBox<Integer> cmbDriverId;
    public JFXComboBox<Integer> cmbCustomerd;
    public JFXTextField txtLocationDistance;
    public JFXButton txtSave;
    public TableView<CustomerPaymentTm> tblCustPayment;
    public Label lblCustomer;
    public Label lblDriver;
    public Label lblVehicle;
    public JFXTextField txtSearch;

    CustomerPaymentBO customerPaymentBO = (CustomerPaymentBO) BOFactory.getInstance().getBO(BOFactory.GetType.CUSTOMER_PAYMENT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadPaymentMethod();
        loadCustomerIds();
        loadVehicleIds();
        loadDriverIds();
    }

    private void loadDriverIds() {
        ArrayList<Integer> allDriversId = customerPaymentBO.getAllDriversId();
        ObservableList<Integer> drivers = FXCollections.observableArrayList();
        for (Integer value:allDriversId){
            drivers.add(value);
        }
        cmbDriverId.setItems(drivers);
    }

    private void loadVehicleIds() {
        ArrayList<Integer> allVehicleId =customerPaymentBO.getAllVehicleId();
        ObservableList<Integer> vehicles = FXCollections.observableArrayList();
        for (Integer value:allVehicleId){
            vehicles.add(value);
        }
        cmbVehicleId.setItems(vehicles);
    }

    private void loadCustomerIds() {
        ArrayList<Integer> customerId = customerPaymentBO.loadId();
        ObservableList<Integer> customers = FXCollections.observableArrayList();
        for (Integer value:customerId){
            customers.add(value);
        }
        cmbCustomerd.setItems(customers);
    }

    private void loadPaymentMethod() {
        ObservableList<String> paymentMethod=FXCollections.observableArrayList();
        paymentMethod.add("Card");
        paymentMethod.add("Cash");
        cmbpaymentMethod.setItems(paymentMethod);
    }

    public void backOnAction(MouseEvent mouseEvent) {
        try{
            AncCustomer.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource("/view/CustomerManagementForm.fxml"));
            AncCustomer.getChildren().add(load);
        }catch (IOException e){
            System.out.println("Cannot load Ui");
        }
    }

    public void saveOnAction(ActionEvent event) {
        try {
            boolean isValid = true;
            String id = cmbCustomerd.getSelectionModel().getSelectedItem().toString();
            String customerFromId = customerPaymentBO.getCustomerFromId(Integer.parseInt(id));
            lblCustomer.setText(customerFromId);
            String paymentMethod = cmbpaymentMethod.getSelectionModel().getSelectedItem().toString();
            String cardNumber = txtCardNumber.getText();
            if (!Pattern.matches("^\\d{12}$", cardNumber)) {
                txtCardNumber.setStyle("-fx-text-fill: RED");
                isValid = false;
            } else {
                txtCardNumber.setStyle("");
            }
            String rental = txtRentalPeriod.getValue().toString();
            String location = txtLocationDistance.getText();
            if (!Pattern.matches("^([1-9]\\d*|0)(\\.\\d+)?\\s?km$", location)) {
                txtLocationDistance.setStyle("-fx-text-fill: RED");
                isValid = false;
            } else {
                txtLocationDistance.setStyle("");
            }
            String driverId = cmbDriverId.getSelectionModel().getSelectedItem().toString();
            String name = customerPaymentBO.getName(Integer.parseInt(driverId));
            lblDriver.setText(name);
            String vehicleId = cmbVehicleId.getSelectionModel().getSelectedItem().toString();
            String brand = customerPaymentBO.getBrand(Integer.parseInt(vehicleId));
            lblVehicle.setText(brand);
            if (id.isEmpty() || paymentMethod.isEmpty() || cardNumber.isEmpty() || rental.isEmpty() || location.isEmpty() || driverId.isEmpty() || vehicleId.isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Please Fill All Values").show();
                return;
            }
            if (!isValid) {
                return;
            }
            boolean isSave =customerPaymentBO.savePayment(new CustomerPaymentDto(Integer.parseInt(id), paymentMethod,
                    cardNumber, Integer.parseInt(vehicleId), rental, location, Integer.parseInt(driverId)));
            if (isSave) {
                new Alert(Alert.AlertType.INFORMATION, "Customer Payment Save Successfully").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Customer Payment Not Saved").show();
            }
        }catch (NullPointerException e){
            System.out.println("Some Values are missing.");
            new Alert(Alert.AlertType.WARNING,"Please check Values Again").show();
        }
    }

//    public boolean savePayment(CustomerPaymentDto Dto) {
//        try {
//            Connection connection = null;
//            try {
//                connection = DBConnection.getInstance().getConnection();
//                connection.setAutoCommit(false);
//                boolean isSave = customerPaymentBO.save(Dto);
//                if (isSave) {
//                    boolean isDelete = customerPaymentBO.delete(Dto.getDriverId());
//                    if (isDelete) {
//                        boolean isRemoveVehicle = customerPaymentBO.deleteVehicle(Dto.getVehicleId());
//                        if (isRemoveVehicle) {
//                            connection.commit();
//                            return true;
//                        } else {
//                            connection.rollback();
//                        }
//                    } else {
//                        connection.rollback();
//                    }
//                } else {
//                    connection.rollback();
//                }
//            } catch (SQLException e) {
//                System.out.println("Place Customer Payment Issue..");
//                if (connection != null) {
//                    connection.rollback();
//                }
//            } finally {
//                connection.setAutoCommit(true);
//            }
//        } catch (SQLException e) {
//            System.out.println("Transaction Issue..");
//        }
//        return false;
//    }

    public void cmbCustomerOnAction(ActionEvent actionEvent) {
        Integer selectedItem = cmbCustomerd.getSelectionModel().getSelectedItem();
        String customerFromId = customerPaymentBO.getCustomerFromId(selectedItem);
        lblCustomer.setText(customerFromId);
    }

    public void cmbVehicleOnAction(ActionEvent actionEvent) {
        Integer selectedItem = cmbVehicleId.getSelectionModel().getSelectedItem();
        String brand = customerPaymentBO.getBrand(selectedItem);
        lblVehicle.setText(brand);
    }

    public void cmDriverOnAction(ActionEvent actionEvent) {
        Integer selectedItem = cmbDriverId.getSelectionModel().getSelectedItem();
        String name = customerPaymentBO.getName(selectedItem);
        lblDriver.setText(name);
    }
}
