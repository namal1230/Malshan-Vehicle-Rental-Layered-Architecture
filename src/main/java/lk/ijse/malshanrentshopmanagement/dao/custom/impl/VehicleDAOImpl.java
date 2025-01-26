package lk.ijse.malshanrentshopmanagement.dao.custom.impl;

import lk.ijse.malshanrentshopmanagement.dao.SQLUtil;
import lk.ijse.malshanrentshopmanagement.dao.custom.VehicleDAO;
import lk.ijse.malshanrentshopmanagement.entity.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDAOImpl implements VehicleDAO {

    public boolean save(Vehicle Dto) {
        try {
            return SQLUtil.execute("INSERT INTO vehicle VALUES (?,?,?,?,?,?,?,?)"
            , Dto.getId(), Dto.getBrand(), Dto.getModel()
            , Dto.getChassie_number(), Dto.getColor(), Dto.getDate(), Dto.getPrice()
            , Dto.getRegistration_code());
        }catch (SQLException e){
            System.out.println("Vehicle save issue");
        }
        return false;
    }

    @Override
    public String generateId() {
        return null;
    }

    public String getId() {
        try {
            ResultSet rst= SQLUtil.execute("SELECT id FROM vehicle ORDER BY id DESC LIMIT 1");
            if (rst.next()) {
                int id = rst.getInt(1);
                String generateId = String.format("%03d", (id + 1));
                return generateId;
            }
        }catch (SQLException e){
            System.out.println("Generate Id Issue..");
            e.printStackTrace();
        }
        return "001";
    }

    public Vehicle getAllVehicle(String chassieNumber) {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM vehicle WHERE chassie_number LIKE ?",chassieNumber);
            if(rst.next()) {
                System.out.println("In this line step 2");
                return new Vehicle(rst.getInt(1), rst.getString(2), rst.getString(3),
                        rst.getString(4), rst.getString(5), rst.getString(6), rst.getDouble(7), rst.getString(8));
            }
        }catch (Exception e){
            System.out.println("Vehicle search issue");
        }
        return null;
    }

    public boolean update(Vehicle Dto) {
        try {
            return SQLUtil.execute("UPDATE vehicle SET brand=?,model=?,color=?,date=?,price=?,registration_code=? WHERE chassie_number=?"
            , Dto.getBrand(), Dto.getModel(), Dto.getColor()
            , Dto.getDate(), Dto.getPrice(), Dto.getRegistration_code(), Dto.getChassie_number());
        }catch (SQLException e){
            System.out.println("Vehicle Update Issue.");
        }
        return false;
    }

    public ArrayList<Vehicle> getAll() {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM vehicle");
            ArrayList<Vehicle> vehicle=new ArrayList<>();
            while (rst.next()){
                vehicle.add(new Vehicle(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),
                        rst.getString(5),rst.getString(6),rst.getDouble(7),rst.getString(8)));
            }return vehicle;
        }catch (SQLException e){
            System.out.println("Get All Vehicle Issue..");
        }
        return null;
    }

    public boolean deleteVehicle(Vehicle vehicleDto) {
        try {
            return SQLUtil.execute("DELETE FROM vehicle WHERE id=?", vehicleDto.getId());
        }catch (SQLException e){
            System.out.println("Vehicle Delete issue");
        }
        return false;
    }

    public ArrayList<Vehicle> search(String text) {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM vehicle WHERE id LIKE '%"+text+"%' OR brand LIKE '%"+text+"%' OR model LIKE '%"+text+"%' OR " +
                    "chassie_number LIKE '%"+text+"%' OR color LIKE '%"+text+"%' OR registration_code LIKE '%"+text+"%'");
            ArrayList<Vehicle> vehicleDtos = new ArrayList<>();
            while (rst.next()) {
                vehicleDtos.add(new Vehicle(rst.getInt(1), rst.getString(2),
                        rst.getString(3), rst.getString(4), rst.getString(5),
                        rst.getString(6), rst.getDouble(7), rst.getString(8)));
            }
            return vehicleDtos;
        }catch (SQLException e){
            System.out.println("Search Vehicle Issue using text");
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Integer> getAllVehicleId() {
        ArrayList<Integer> vehicleId = new ArrayList<>();
        try {
            ResultSet resultSet = SQLUtil.execute("SELECT id FROM vehicle");
            while (resultSet.next()){
                vehicleId.add(resultSet.getInt(1));
            }
        }catch (SQLException e){
            System.out.println("Get all vehicle id Issue..");
            e.printStackTrace();
        }
        return vehicleId;
    }

    public String getBrand(Object selectedItem) {
        try {
            ResultSet resultSet = SQLUtil.execute("SELECT brand FROM vehicle WHERE id=?",selectedItem.toString());
            if(resultSet.next()){
                return resultSet.getString("brand");
            }
        } catch (SQLException e) {
            System.out.println("Get Vehicle Brand Issue...");
        }
        return null;
    }

    public boolean delete(int text) {
        try {
            return SQLUtil.execute("DELETE FROM vehicle WHERE id=?", text);
        }catch (SQLException e){
            System.out.println("Vehicle Delete issue");
        }
        return false;
    }

    public Vehicle getAllValues(String chassies) {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM vehicle WHERE chassie_number=?",chassies);
            while (rst.next()) {
                return new Vehicle(rst.getInt(1), rst.getString(2), rst.getString(3),
                        rst.getString(4), rst.getString(5), rst.getString(6), rst.getDouble(7), rst.getString(8));
            }
        }catch (SQLException e){
            System.out.println("get Vehicle From chassie number Issue..");
        }
        return null;
    }

    public boolean searchFromId(String text) {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM vehicle WHERE chassie_number=?",text);
            if (rst.next()) {
                return true;
            }
        }catch (SQLException e){
            System.out.println("get Vehicle From chassie number Issue..");
        }
        return false;
    }
}
