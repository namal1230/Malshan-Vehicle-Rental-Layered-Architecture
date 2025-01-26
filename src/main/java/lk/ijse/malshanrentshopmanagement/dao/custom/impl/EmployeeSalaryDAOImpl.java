package lk.ijse.malshanrentshopmanagement.dao.custom.impl;

import lk.ijse.malshanrentshopmanagement.dao.SQLUtil;
import lk.ijse.malshanrentshopmanagement.dao.custom.EmployeeSalaryDAO;
import lk.ijse.malshanrentshopmanagement.entity.EmployeeSalary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeSalaryDAOImpl implements EmployeeSalaryDAO {
    public boolean save(EmployeeSalary Dto) {
        try {
            return SQLUtil.execute("INSERT INTO employee_salary VALUES(?,?,?,?,?,?)", Dto.getId(),
             Dto.getSalary(), Dto.getBank_account(), Dto.getTax(), Dto.getProbation_period(), Dto.getDate());
        }catch (SQLException e){
            System.out.println("Save Employee Issue..");
        }
        return false;
    }

    @Override
    public String generateId() {
        return null;
    }

    @Override
    public EmployeeSalary getAllValues(String text) {
        return null;
    }

    public ArrayList<EmployeeSalary> getAll() {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM employee_salary");
            ArrayList<EmployeeSalary> employeeSalaryDtos = new ArrayList<>();
            while (rst.next()) {
                employeeSalaryDtos.add(new EmployeeSalary(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6)));
            }
            return employeeSalaryDtos;
        }catch (SQLException e){
            System.out.println("Get All Employee Salary Issue..");
        }
        return null;
    }

    public boolean delete(int text) {
        try {
            return SQLUtil.execute("DELETE FROM employee_salary WHERE id=?",  text);
        }catch (SQLException e){
            System.out.println("Delete Employee Salary Issue..");
        }
        return false;
    }

    public boolean searchEmployeeId(int id) {
        try {
            ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee_salary WHERE id=?", id);
            if (resultSet.next()) {
                return true;
            }
        }catch (SQLException e){
            System.out.println("Search Employee Id Issue..");
        }
        return false;
    }

    public boolean update(EmployeeSalary Dto) {
        try {
            return SQLUtil.execute("UPDATE FROM employee_salary SET salary=?, bank_account=?, tax=?, probation_period=?, date=? WHERE id=?", Dto.getSalary(),
            Dto.getBank_account(), Dto.getTax(), Dto.getProbation_period(), Dto.getDate(), Dto.getId());
        }catch (SQLException e){
            System.out.println("Employee Update Issue..");
        }
        return false;
    }

    public ArrayList<EmployeeSalary> search(String text) {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM employee_salary WHERE id LIKE '%" + text + "%' OR salary LIKE '%" + text + "%' OR bank_account LIKE '%" + text + "%' OR " +
                    "tax LIKE '%" + text + "%' OR probation_period LIKE '%" + text + "%' OR date LIKE '%" + text + "%'");
            ArrayList<EmployeeSalary> employeeSalaryDtos = new ArrayList<>();
            while (rst.next()) {
                employeeSalaryDtos.add(new EmployeeSalary(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6)));
            }
            return employeeSalaryDtos;
        }catch (SQLException e){
            System.out.println("Search Employee Salary Issue..");
        }
        return null;
    }

    @Override
    public boolean searchFromId(String id) {
        return false;
    }
}
