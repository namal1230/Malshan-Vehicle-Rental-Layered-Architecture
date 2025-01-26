package lk.ijse.malshanrentshopmanagement.dao.custom.impl;

import lk.ijse.malshanrentshopmanagement.dao.SQLUtil;
import lk.ijse.malshanrentshopmanagement.dao.custom.DriverDAO;
import lk.ijse.malshanrentshopmanagement.entity.Driver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DriverDAOImpl implements DriverDAO {

    public boolean save(Driver Dto) {
        try {
            return SQLUtil.execute("INSERT INTO driver (name,address,contact,email,dob,nic,license_number,license_exp,license_type,medical,status) VALUES (?,?,?,?,?,?,?,?,?,?,?)",
            Dto.getName(), Dto.getAddress(), Dto.getContact(), Dto.getEmail()
            , Dto.getDob(), Dto.getNic(), Dto.getLicense_number(), Dto.getLicense_exp()
            , Dto.getLicense_type(), Dto.getMedical(), Dto.getStatus());
        }catch (SQLException e){
            System.out.println("Driver Save Issue..");
        }
        return false;
    }

    @Override
    public String generateId() {
        return null;
    }

    public boolean delete(String id) {
        try {
            return SQLUtil.execute("DELETE FROM driver WHERE nic=?", id);
        }catch (SQLException e){
            System.out.println("Driver Delete Issue..");
        }
        return false;
    }

    public boolean searchFromId(String id) {
        try {
            ResultSet rst= SQLUtil.execute("SELECT * FROM driver WHERE nic=?", id);
            if (rst.next()){
                return true;
            }
        }catch (SQLException e){
            System.out.println("Search Driver Nic Issue..");
        }
        return false;
    }

    public boolean update(Driver Dto) {
        try {
            return SQLUtil.execute("UPDATE driver SET name=? , address=?, contact=?, email=?, dob=? , liense_number=?,license_exp=?, license_type=?, medical=?, status=? WHERE nic=?",
                    Dto.getName(), Dto.getAddress(), Dto.getContact(), Dto.getEmail()
            , Dto.getDob(), Dto.getLicense_number(), Dto.getLicense_exp(), Dto.getLicense_type()
            , Dto.getMedical(), Dto.getStatus(), Dto.getNic());
        }catch (SQLException e){
            System.out.println("Driver Upate Issue..");
        }
        return false;
    }

    @Override
    public boolean delete(int text) {
        return false;
    }

    public ArrayList<Driver> getAll() {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM driver");
            ArrayList<Driver> drivers = new ArrayList<>();
            while (rst.next()) {
                Driver driverDto=new Driver(rst.getInt(1),rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),rst.getString(6)
                        , rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11), rst.getString(12));
                drivers.add(driverDto);
            }
            return drivers;
        } catch (SQLException e){
            System.out.println("Get All Drivers Issue..");
        }
        return null;
    }

    public Driver getAllValues(String text) {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM driver WHERE license_number=?", text);
            if (rst.next()) {
                return new Driver(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),
                        rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11), rst.getString(12));
            }
        } catch (SQLException e) {
            System.out.println("Get All Drivers From license Issue..");
        }
        return null;
    }

    public ArrayList<Driver> search(String text) {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM driver WHERE id LIKE '%" + text + "%' OR name LIKE '%" + text + "%' OR address LIKE '%" + text + "%' OR " +
                    "contact LIKE '%" + text + "%' OR email LIKE '%" + text + "%' OR dob LIKE '%" + text + "%' OR nic LIKE '%" + text + "%' OR license_number LIKE '%" + text + "%' OR license_exp LIKE '%" + text + "%' OR license_type LIKE '%" + text
                    + "%' OR medical LIKE '%" + text + "%' OR status LIKE '%" + text + "%'");
            ArrayList<Driver> drivers = new ArrayList<>();

            while (rst.next()) {
                drivers.add(new Driver(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),
                        rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11), rst.getString(12)));
            }
            return drivers;
        } catch (SQLException e) {
            System.out.println("Search Driver Issue..");
        }
        return null;
    }

    public ArrayList<Integer> getAllDriversId() {
        try {
            ResultSet rst = SQLUtil.execute("SELECT id FROM driver");
            ArrayList<Integer> objects = new ArrayList<>();
            while (rst.next()) {
                objects.add(rst.getInt(1));
            }
            return objects;
        }catch (SQLException e){
            System.out.println("Get All ID From Drivers Issue..");
        }
        return null;
    }

    public String getName(int selectedItem) {
        try {
            ResultSet resultSet = SQLUtil.execute("SELECT name FROM driver WHERE id=?",selectedItem);
            if (resultSet.next()) return resultSet.getString("name");
        }catch (SQLException e){
            System.out.println("Get Driver Name Issue..");
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteDriver(String text) {
        try {
            return SQLUtil.execute("DELETE FROM driver WHERE id=?", text);
        }catch (SQLException e){
            System.out.println("Driver Delete Issue..");
        }
        return false;
    }
}
