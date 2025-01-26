package lk.ijse.malshanrentshopmanagement.dao.custom.impl;

import lk.ijse.malshanrentshopmanagement.dao.SQLUtil;
import lk.ijse.malshanrentshopmanagement.dao.custom.CustomerDAO;
import lk.ijse.malshanrentshopmanagement.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    public boolean save(Customer Dto) {
        try {
            return SQLUtil.execute("INSERT INTO customer VALUES (?,?,?,?,?,?,?,?,?,?,?)",
                    Dto.getId(), Dto.getName(), Dto.getAddress(),
                    Dto.getContact(), Dto.getNic(), Dto.getDob(),
                    Dto.getEmail(), Dto.getDriverId(), Dto.getLicen_number(), Dto.getVehicleId(),Dto.getDate());
        }catch (SQLException e){
            System.out.println("Save Customer Issue..");
            e.printStackTrace();
        }
        return false;
    }

    public String generateId() {
        try {
            ResultSet resultSet = SQLUtil.execute("SELECT id FROM customer ORDER BY id DESC LIMIT 1");
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String format = String.format("%03d", (id+1));
                return format;
            }
        }catch(SQLException e){
            System.out.println("Generate Customer id Issue..");
        }
        return "001";
    }

    public ArrayList<Customer> getAll() {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM customer");
            ArrayList<Customer> objects = new ArrayList<>();
            while (rst.next()) {
                objects.add(new Customer(rst.getInt(1), rst.getString(2),
                        rst.getString(3), rst.getString(4), rst.getString(5),
                        rst.getString(6), rst.getString(7), rst.getInt(8),
                        rst.getString(9), rst.getInt(10),rst.getString(11)));
            }
            return objects;
        } catch (SQLException e) {
            System.out.println("Get All Customers Issue..");
        }
        return null;
    }

    public ArrayList<Customer> search(String text) {
        try{
            ResultSet rst = SQLUtil.execute("SELECT * FROM customer WHERE id LIKE '%" + text + "%' OR name LIKE '%" + text + "%' OR address LIKE '%" + text + "%' OR " +
                    "contact LIKE '%" + text + "%' OR nic LIKE '%" + text + "%' OR dob LIKE '%" + text + "%' OR email LIKE '%" + text + "%' OR driverId LIKE '%" + text + "%' OR licen_number LIKE '%" + text + "%' OR vehicleid LIKE '%" + text
                    + "%'");
            ArrayList<Customer> customer = new ArrayList<>();
            while (rst.next()) {
                customer.add(new Customer(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),
                    rst.getString(5),rst.getString(6),rst.getString(7),rst.getInt(8),rst.getString(9),rst.getInt(10),rst.getString(11)));
            }
            return customer;
        }catch (SQLException e){
            System.out.println("Get All Customer Issue..");
        }
        return null;
    }

    public boolean searchFromId(String id) {
        try {
            ResultSet rst= SQLUtil.execute("SELECT * FROM customer WHERE id=?",id);
            if (rst.next()){
                return true;
            }
        }catch (SQLException e){
            System.out.println("Get All Customer From Id Issue..");
        }
        return false;
    }

    public boolean update(Customer Dto) {
        try {
            return SQLUtil.execute("UPDATE customer SET name=?,address=?,contact=?,nic=?,dob=?,email=?,driverId=?,licen_number=?,vehicleid=?,date=? WHERE id=?",
            Dto.getName(),Dto.getAddress(),Dto.getContact(),Dto.getNic(),
                    Dto.getDob(), Dto.getEmail(),Dto.getDriverId(),Dto.getLicen_number(),
                    Dto.getVehicleId(),Dto.getDate(),Dto.getId());
        }catch (SQLException e){
            System.out.println("Update Customer Issue..");
        }
        return false;
    }

    public boolean delete(int text) {
        try {
            return SQLUtil.execute("DELETE FROM customer WHERE id=?",text);
        }catch (SQLException e){
            System.out.println("DELETE Customer Issue..");
        }
        return false;
    }


    public Customer getAllValues(String text) {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM customer WHERE nic=?",text );
            if (rst.next()) {
                return new Customer(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
                        rst.getString(5), rst.getString(6), rst.getString(7), rst.getInt(8), rst.getString(9), rst.getInt(10),rst.getString(11));
            }
        }catch (SQLException e){
            System.out.println("Get Customer From nic Issue..");
        }
        return null;
    }

    public String getCustomerFromId(int id) {
        try {
            ResultSet resultSet = SQLUtil.execute("SELECT name FROM customer WHERE id=?",id);
            if (resultSet.next()) {
                return resultSet.getString("name");
            }
        }catch (SQLException e){
            System.out.println("Get Customer NAme from Id Issue..");
        }
        return null;
    }
}