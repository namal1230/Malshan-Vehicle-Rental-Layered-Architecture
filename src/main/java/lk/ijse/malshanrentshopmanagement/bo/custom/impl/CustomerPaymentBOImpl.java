package lk.ijse.malshanrentshopmanagement.bo.custom.impl;

import lk.ijse.malshanrentshopmanagement.bo.custom.CustomerPaymentBO;
import lk.ijse.malshanrentshopmanagement.dao.DAOFactory;
import lk.ijse.malshanrentshopmanagement.dao.custom.CustomerDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.CustomerPaymentDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.DriverDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.VehicleDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.CustomerPaymentDAOImpl;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.DriverDAOImpl;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.VehicleDAOImpl;
import lk.ijse.malshanrentshopmanagement.db.DBConnection;
import lk.ijse.malshanrentshopmanagement.dto.CustomerPaymentDto;
import lk.ijse.malshanrentshopmanagement.entity.CustomerPayment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerPaymentBOImpl implements CustomerPaymentBO {
    CustomerPaymentDAO customerPaymentDAO = (CustomerPaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.CUSTOMER_PAYMENT);
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.CUSTOMER);
    DriverDAO driverDAO = (DriverDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.DRIVER);
    VehicleDAO vehicleDAO = (VehicleDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.VEHICLE);

    public boolean savePayment(CustomerPaymentDto Dto) {
        try {
            Connection connection = null;
            try {
                connection = DBConnection.getInstance().getConnection();
                connection.setAutoCommit(false);
                boolean isSave = customerPaymentDAO.save(new CustomerPayment(
                        Dto.getCustomerId(),Dto.getMethod(),Dto.getCardNumber(),
                        Dto.getVehicleId(),Dto.getRentalPeriod(),Dto.getLocationDistance(),Dto.getDriverId()
                ));
                if (isSave) {
                    boolean isDelete = driverDAO.delete(Dto.getDriverId());
                    if (isDelete) {
                        boolean isRemoveVehicle = vehicleDAO.delete(Dto.getVehicleId());
                        if (isRemoveVehicle) {
                            connection.commit();
                            return true;
                        } else {
                            connection.rollback();
                        }
                    } else {
                        connection.rollback();
                    }
                } else {
                    connection.rollback();
                }
            } catch (SQLException e) {
                System.out.println("Place Customer Payment Issue..");
                if (connection != null) {
                    connection.rollback();
                }
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            System.out.println("Transaction Issue..");
        }
        return false;
    }
    @Override
    public ArrayList<Integer> loadId() {
        return customerPaymentDAO.loadId();
    }

    @Override
    public boolean save(CustomerPaymentDto Dto) {
        return customerPaymentDAO.save(new CustomerPayment( Dto.getCustomerId(),Dto.getMethod(),Dto.getCardNumber(),
                Dto.getVehicleId(),Dto.getRentalPeriod(),Dto.getLocationDistance(),Dto.getDriverId()));
    }

    @Override
    public String getCustomerFromId(int id) {
        return customerDAO.getCustomerFromId(id);
    }

    @Override
    public ArrayList<Integer> getAllDriversId() {
        return driverDAO.getAllDriversId();
    }

    @Override
    public String getName(int selectedItem) {
        return driverDAO.getName(selectedItem);
    }

    @Override
    public boolean delete(int text) {
        return driverDAO.delete(text);
    }

    @Override
    public ArrayList<Integer> getAllVehicleId() {
        return vehicleDAO.getAllVehicleId();
    }

    @Override
    public String getBrand(Object selectedItem) {
        return vehicleDAO.getBrand(selectedItem);
    }

    @Override
    public boolean deleteVehicle(int vehicleId) {
        return vehicleDAO.delete(vehicleId);
    }
}
