package lk.ijse.malshanrentshopmanagement.dao.custom.impl;

import lk.ijse.malshanrentshopmanagement.dao.SQLUtil;
import lk.ijse.malshanrentshopmanagement.dao.custom.EliminateEmployeeDAO;
import lk.ijse.malshanrentshopmanagement.entity.EliminateEmployee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EliminateEmployeeDAOImpl implements EliminateEmployeeDAO {
    @Override
    public EliminateEmployee getAllValues(String text) {
        return null;
    }

    public ArrayList<EliminateEmployee> getAll() {
        try {
            ResultSet rst =  SQLUtil.execute("SELECT * FROM eliminate_employee");
            ArrayList<EliminateEmployee> eliminateEmployeeDtos = new ArrayList<>();
            while (rst.next()) {
                eliminateEmployeeDtos.add(new EliminateEmployee(rst.getInt(1), rst.getString(2), rst.getString(3),
                        rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9),
                        rst.getString(10), rst.getString(11), rst.getString(12), rst.getString(13)));
            }
            return eliminateEmployeeDtos;
        }catch (SQLException e){
            System.out.println("Get All Eliminate Employee Issue..");
        }
        return null;
    }

    @Override
    public boolean save(EliminateEmployee Dto) {
        return false;
    }

    @Override
    public String generateId() {
        return null;
    }

    public ArrayList<EliminateEmployee> search(String text) {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM eliminate_employee WHERE id LIKE '%" + text + "%' OR name LIKE '%" + text + "%' OR address LIKE '%" + text + "%' OR " +
                    "contact LIKE '%" + text + "%' OR email LIKE '%" + text + "%' OR dob LIKE '%" + text + "%' OR job_role LIKE '%" + text + "%'");
            ArrayList<EliminateEmployee> employeeDtos = new ArrayList<>();
            while (rst.next()) {
                employeeDtos.add(new EliminateEmployee(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
                        rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9),
                        rst.getString(10), rst.getString(11), rst.getString(12), rst.getString(13)));
            }
            return employeeDtos;
        }catch (SQLException e){
            System.out.println("Search Eliminate Employee Issue..");
        }
        return null;
    }

    @Override
    public boolean searchFromId(String id) {
        return false;
    }

    @Override
    public boolean update(EliminateEmployee customerDto) {
        return false;
    }

    public boolean saveEliminateEmployee(int id) {
        try {
            return SQLUtil.execute( "INSERT INTO eliminate_employee (name, address, contact, email, dob, job_role, department, nic, status, hire_date, period, period_date) SELECT name, address, contact, email, dob, job_role, department, nic, status, hire_date, period, period_date FROM employee WHERE id = ?",id);
        }catch (SQLException e){
            System.out.println("Insert Eliminate Employee Issue..");
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int text) {
        try {
            return SQLUtil.execute("DELETE FROM eliminate_employee WHERE id=?",text);
        }catch (SQLException e){
            System.out.println("Delete Eliminate Employee Issue..");
        }
        return false;
    }

}
