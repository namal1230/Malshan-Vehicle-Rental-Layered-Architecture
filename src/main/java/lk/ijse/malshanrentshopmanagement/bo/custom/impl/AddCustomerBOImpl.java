package lk.ijse.malshanrentshopmanagement.bo.custom.impl;

import lk.ijse.malshanrentshopmanagement.bo.custom.AddCustomerBO;
import lk.ijse.malshanrentshopmanagement.dao.custom.CustomerDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.DriverDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.VehicleDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.DriverDAOImpl;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.VehicleDAOImpl;
import lk.ijse.malshanrentshopmanagement.dto.CustomerDto;
import lk.ijse.malshanrentshopmanagement.dto.VehicleDto;
import lk.ijse.malshanrentshopmanagement.entity.Customer;

import java.util.ArrayList;

public class AddCustomerBOImpl implements AddCustomerBO {

    CustomerDAO customerDAO = new CustomerDAOImpl();
    DriverDAO driverDAO = new DriverDAOImpl();

    VehicleDAO vehicleDAO = new VehicleDAOImpl();

    @Override
    public CustomerDto getAllValues(String text) {
        Customer allValues = customerDAO.getAllValues(text);
        return new CustomerDto(allValues.getId(),allValues.getName(),allValues.getAddress(),
                allValues.getContact(),allValues.getNic(),allValues.getDob(),allValues.getEmail(),
                allValues.getDriverId(),allValues.getLicen_number(),allValues.getVehicleId(),
                allValues.getDate());
    }

    @Override
    public boolean save(CustomerDto customerDto) {
        return customerDAO.save(new Customer(customerDto.getId(),customerDto.getName(),customerDto.getAddress(),
                customerDto.getContact(),customerDto.getNic(),customerDto.getDob(),customerDto.getEmail(),
                customerDto.getDriverId(),customerDto.getLicen_number(),customerDto.getVehicleId(),
                customerDto.getDate()));
    }

    @Override
    public String generateId() {
        return customerDAO.generateId();
    }

    @Override
    public boolean searchFromId(String id) {
        return customerDAO.searchFromId(id);
    }

    @Override
    public boolean update(CustomerDto customerDto) {
        return customerDAO.update(new Customer(customerDto.getId(),customerDto.getName(),customerDto.getAddress(),
                customerDto.getContact(),customerDto.getNic(),customerDto.getDob(),customerDto.getEmail(),
                customerDto.getDriverId(),customerDto.getLicen_number(),customerDto.getVehicleId(),
                customerDto.getDate()));
    }

    @Override
    public ArrayList<Integer> getAllDriversId() {
        return driverDAO.getAllDriversId();
    }

    @Override
    public String getNameDriver(int selectedItem) {
        return driverDAO.getName(selectedItem);
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
    public String getCustomerFromId(int i) {
        return customerDAO.getCustomerFromId(i);
    }
}
