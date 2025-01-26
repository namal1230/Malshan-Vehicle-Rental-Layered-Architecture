package lk.ijse.malshanrentshopmanagement.controller;

import lk.ijse.malshanrentshopmanagement.bo.BOFactory;
import lk.ijse.malshanrentshopmanagement.bo.custom.VehicleSummaryBO;
import lk.ijse.malshanrentshopmanagement.bo.custom.impl.VehicleSummaryBOImpl;
import lk.ijse.malshanrentshopmanagement.dto.VehicleSummaryDto;
import lk.ijse.malshanrentshopmanagement.dto.tm.VehicleSummaryTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VehicleSummaryFormController implements Initializable {
    public TableView<VehicleSummaryTm> tblVehicle;
    public TableColumn<VehicleSummaryTm,String> colBrand;
    public TableColumn<VehicleSummaryTm,String> colModel;
    public TableColumn<VehicleSummaryTm,String> colChassieNumber;
    public TableColumn<VehicleSummaryTm,String> colColor;
    public TableColumn<VehicleSummaryTm,String> colPolicyNumber;
    public TableColumn<VehicleSummaryTm,String> colPolicyType;
    public TableColumn<VehicleSummaryTm,String> colMaintenenceType;
    public TableColumn<VehicleSummaryTm,String>  colRegisterCode;
    public TableColumn<VehicleSummaryTm,String>  colInsurance;
    VehicleSummaryBO vehicleSummaryBO = (VehicleSummaryBO) BOFactory.getInstance().getBO(BOFactory.GetType.VEHICLE_SUMMARY);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colChassieNumber.setCellValueFactory(new PropertyValueFactory<>("chassie_number"));
        colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        colRegisterCode.setCellValueFactory(new PropertyValueFactory<>("register_code"));
        colInsurance.setCellValueFactory(new PropertyValueFactory<>("provider"));
        colPolicyNumber.setCellValueFactory(new PropertyValueFactory<>("policynumber"));
        colPolicyType.setCellValueFactory(new PropertyValueFactory<>("policyType"));
        colMaintenenceType.setCellValueFactory(new PropertyValueFactory<>("MaintenanceType"));
        loadtable();

    }

    private void loadtable() {
        try {
            ArrayList<VehicleSummaryDto> allVehicle = vehicleSummaryBO.getAll();
            ObservableList<VehicleSummaryTm> objects = FXCollections.observableArrayList();
            for (VehicleSummaryDto vehicleDto : allVehicle) {
                VehicleSummaryTm vehicleTm = new VehicleSummaryTm(vehicleDto.getBrand(),vehicleDto.getModel(),vehicleDto.getChassie_number(),vehicleDto.getColor(),
                        vehicleDto.getRegister_code(),vehicleDto.getProvider(),vehicleDto.getPolicynumber(),vehicleDto.getPolicyType(),vehicleDto.getMaintenanceType());
                objects.add(vehicleTm);
            }
            tblVehicle.setItems(objects);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
