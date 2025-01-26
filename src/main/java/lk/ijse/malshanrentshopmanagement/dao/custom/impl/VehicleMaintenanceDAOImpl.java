package lk.ijse.malshanrentshopmanagement.dao.custom.impl;

import lk.ijse.malshanrentshopmanagement.dao.SQLUtil;
import lk.ijse.malshanrentshopmanagement.dao.custom.VehicleMaintenanceDAO;
import lk.ijse.malshanrentshopmanagement.entity.VehicleMaintenance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleMaintenanceDAOImpl implements VehicleMaintenanceDAO {
    public boolean save(VehicleMaintenance Dto) {
        try {
            return SQLUtil.execute("INSERT INTO vehicle_maintenance VALUES(?,?,?,?,?,?)"
            , Dto.getId(), Dto.getVehicle_chassis(), Dto.getMaintenance_type()
            , Dto.getLast_maintenance(), Dto.getNext_maintenance(),Dto.getRepairCost());
        }catch (SQLException e){
            System.out.println("Maintenance Save Issue");
        }
        return false;
    }

    @Override
    public String generateId() {
        return null;
    }

    public int getId() {
        try {
            ResultSet resultSet = SQLUtil.execute("SELECT id FROM vehicle_maintenance ORDER BY id DESC LIMIT 1");
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        }catch (SQLException e){
            System.out.println("Get MaintainanceId Issue..");
        }
        return 0;
    }

    @Override
    public VehicleMaintenance getAllValues(String text) {
        return null;
    }

    public ArrayList<VehicleMaintenance> getAll() {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM vehicle_maintenance");
            ArrayList<VehicleMaintenance> objects = new ArrayList<>();
            while (rst.next()) {
                objects.add(new VehicleMaintenance(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getDouble(6)));
            }
            return objects;
        }catch(SQLException e) {
            System.out.println("Get Maintenance Isuue..");
        }
        return null;
    }

    public boolean searchFromId(String id) {
        try{
            ResultSet resultSet = SQLUtil.execute("SELECT * FROM vehicle_maintenance WHERE id=?",id);
            if (resultSet.next()) return true;
        }catch (SQLException e){
            System.out.println("Vehicle Maintenance SearchId Issue..");
        }
        return false;
    }

    public boolean update(VehicleMaintenance Dto) {
        try {
            return SQLUtil.execute("UPDATE vehicle_maintenance SET vehicle_chassis=? , maintenance_type=?, last_maintenance=?, next_maintenance=?, repairCost=? WHERE id=?",
             Dto.getVehicle_chassis(), Dto.getMaintenance_type(), Dto.getLast_maintenance()
            , Dto.getNext_maintenance(), Dto.getRepairCost(),Dto.getId());
        }catch (SQLException e){
            System.out.println("Maintenance Update Issue..");
        }
        return false;
    }

    public boolean delete(int text) {
        try {
            return SQLUtil.execute("DELETE FROM vehicle_maintenance WHERE id=?", text);
        } catch (SQLException e){
            System.out.println("MAintenance DElete Issue..");
        }
        return false;
    }

    public ArrayList<VehicleMaintenance> search(String text) {
        try {
            ResultSet resultSet = SQLUtil.execute("SELECT * FROM vehicle_maintenance WHERE id LIKE '%" + text + "%' OR vehicle_chassis LIKE '%" + text + "%' OR maintenance_type LIKE '%" + text + "%' OR " +
                    "last_maintenance LIKE '%" + text + "%' OR next_maintenance LIKE '%" + text + "%' OR repairCost LIKE '%" + text + "%'");
            ArrayList<VehicleMaintenance> objects = new ArrayList<>();
            while (resultSet.next()){
                objects.add(new VehicleMaintenance(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getDouble(6)));
            }
            return objects;
        }catch(SQLException e){
            System.out.println("Search Maintenance Issue..");
        }
        return null;
    }
}
