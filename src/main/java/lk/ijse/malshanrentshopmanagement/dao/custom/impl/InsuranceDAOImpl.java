package lk.ijse.malshanrentshopmanagement.dao.custom.impl;

import lk.ijse.malshanrentshopmanagement.dao.SQLUtil;
import lk.ijse.malshanrentshopmanagement.dao.custom.InsuranceDAO;
import lk.ijse.malshanrentshopmanagement.entity.Insurance;

import java.sql.*;
import java.util.ArrayList;

public class InsuranceDAOImpl implements InsuranceDAO {
    public boolean save(Insurance Dto) {
        try {
            return SQLUtil.execute("INSERT INTO insurance VALUES (?,?,?,?,?,?,?)",
                    Dto.getId(), Dto.getInsu_provider(), Dto.getVehicle_chassis()
            , Dto.getInsu_policy_number(), Dto.getInsu_policy_type(), Dto.getStartDate()
            , Dto.getExpiryDate());
        }catch (SQLException e){
            System.out.println("Save Insurance issue..");
        }
        return false;
    }

    @Override
    public String generateId() {
        return null;
    }

    public int getInsuranceId() {
        try {
            ResultSet resultSet = SQLUtil.execute("SELECT id FROM insurance ORDER BY id DESC LIMIT 1");
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                return id;
            }
        }catch (SQLException e){
            System.out.println("InsuranceGet Id Issue..");
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Insurance getAllValues(String text) {
        return null;
    }

    public ArrayList<Insurance> getAll() {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM insurance");
            ArrayList<Insurance> insuranceDtos = new ArrayList<>();
            while (rst.next()) {
                Insurance insuranceDto = new Insurance(rst.getInt(1), rst.getString(2), rst.getString(3),
                        rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7));
                insuranceDtos.add(insuranceDto);
            }
            return insuranceDtos;
        }catch (SQLException e){
            System.out.println("Get All Insurance Issue..");
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Insurance> search(String text) {
        try {
            ResultSet resultSet = SQLUtil.execute("SELECT * FROM insurance WHERE id LIKE '%" + text + "%' OR insu_provider LIKE '%" + text + "%' OR vehicle_chassis LIKE '%" + text + "%' OR " +
                            "insu_policy_number LIKE '%" + text + "%' OR insu_policy_type LIKE '%" + text + "%' OR startDate LIKE '%" + text + "%' OR expiryDate LIKE '%" + text + "%'");
            ArrayList<Insurance> insurance = new ArrayList<>();
            while (resultSet.next()) {
                insurance.add(new Insurance(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7)));
            }
            return insurance;
        }catch (SQLException e){
            System.out.println("Search Insurance Issue..");
        }
        return null;
    }

    @Override
    public boolean searchFromId(String id) {
        return false;
    }

    public boolean delete(String text) {
        try {
            return SQLUtil.execute("DELETE FROM insurance WHERE id=?",Integer.parseInt(text));
        }catch (SQLException e){
            System.out.println("Insurance delete issue..");
        }
        return false;
    }

    public boolean checkId(String id) {
        try {
            ResultSet resultSet = SQLUtil.execute("SELECT * FROM insurance WHERE id=?",Integer.parseInt(id));
            if (resultSet.next()) {
                return true;
            }
        }catch (SQLException e){
            System.out.println("Chek id Issue..");
        }
        return false;
    }

    public boolean update(Insurance Dto) {
        try {
            return SQLUtil.execute(" UPDATE insurance SET insu_provider=? , vehicle_chassis=? , insu_policy_number = ? , insu_policy_type=? , startDate = ?, expiryDate=? WHERE id=?;"
            ,Dto.getInsu_provider(), Dto.getVehicle_chassis(), Dto.getInsu_policy_number(),Dto.getInsu_policy_type()
                    , Dto.getStartDate(), Dto.getExpiryDate(),Dto.getId());
        }catch (SQLException e){
            System.out.println("Insurance Update Issue..");
        }
        return false;
    }

    @Override
    public boolean delete(int text) {
        return false;
    }
}
