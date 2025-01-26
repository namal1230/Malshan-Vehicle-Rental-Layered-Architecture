package lk.ijse.malshanrentshopmanagement.dao.custom.impl;

import lk.ijse.malshanrentshopmanagement.dao.SQLUtil;
import lk.ijse.malshanrentshopmanagement.dao.custom.CustomerPaymentDAO;
import lk.ijse.malshanrentshopmanagement.entity.CustomerPayment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerPaymentDAOImpl implements CustomerPaymentDAO {


    public boolean save(CustomerPayment Dto) {
        try {
            return SQLUtil.execute( "INSERT INTO customer_payment VALUES(?,?,?,?,?,?,?)",Dto.getCustomerId(),Dto.getMethod(),
                    Dto.getCardNumber(),Dto.getVehicleId(),Dto.getRentalPeriod(),Dto.getLocationDistance(),Dto.getDriverId());
        } catch (SQLException e) {
            System.out.println("Customer Payment Save Issue..");
        }
        return false;
    }

    @Override
    public String generateId() {
        return null;
    }

    public ArrayList<Integer> loadId() {
        try {
            ResultSet resultSet = SQLUtil.execute("SELECT id FROM customer");
            ArrayList<Integer> customersId = new ArrayList<>();
            while (resultSet.next()) {
                customersId.add(resultSet.getInt("id"));
            }
            return customersId;
        } catch (SQLException e) {
            System.out.println("Get All Customer Id Issue..");
        }
        return null;
    }

    @Override
    public CustomerPayment getAllValues(String text) {
        return null;
    }

    public ArrayList<CustomerPayment> getAll() {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM customer_payment");
            ArrayList<CustomerPayment> customerPaymentDtos = new ArrayList<>();
            while (rst.next()) {
                customerPaymentDtos.add(new CustomerPayment(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5), rst.getString(6), rst.getInt(7)));
            }
            return customerPaymentDtos;
        } catch (SQLException e) {
            System.out.println("Get all customer Payment Issue..");
        }
        return null;
    }

    public ArrayList<CustomerPayment> search(String text) {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM customer_payment WHERE customer_id LIKE '%" + text + "%' OR method LIKE '%" + text + "%' OR card_number LIKE '%" + text + "%' OR " +
                    "vehicle_id LIKE '%" + text + "%' OR rental_period LIKE '%" + text + "%' OR location_distance LIKE '%" + text + "%' OR driver_id LIKE '%" + text + "%'");
            ArrayList<CustomerPayment> customerPaymentDtos = new ArrayList<>();
            while (rst.next()) {
                customerPaymentDtos.add(new CustomerPayment(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5), rst.getString(6),
                        rst.getInt(7)));
            }
            return customerPaymentDtos;
        }catch (SQLException e){
            System.out.println("Searh Customer Payment Issue..");
        }
        return null;
    }

    @Override
    public boolean searchFromId(String id) {
        return false;
    }

    @Override
    public boolean update(CustomerPayment customerDto) {
        return false;
    }

    @Override
    public boolean delete(int text) {
        return false;
    }

}


