package lk.ijse.malshanrentshopmanagement.dao.custom.impl;

import lk.ijse.malshanrentshopmanagement.dao.SQLUtil;
import lk.ijse.malshanrentshopmanagement.dao.custom.EmployeeDAO;
import lk.ijse.malshanrentshopmanagement.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    public boolean save(Employee Dto) {
        try {
            return SQLUtil.execute("INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)",Dto.getId(),Dto.getName(), Dto.getAddress(),Dto.getContact(),
                    Dto.getEmail(),Dto.getDob(),Dto.getJobRole(),Dto.getDepartment(),Dto.getNic(),Dto.getStatus(),Dto.getHire(),Dto.getPeriod(),Dto.getPeriodDate());
        } catch (SQLException e) {
            System.out.println("Employee Save Issue..");
        }
        return false;
    }

    public String generateId() {
        try {
            ResultSet resultSet = SQLUtil.execute("SELECT id FROM employee ORDER BY id DESC LIMIT 1");
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String format = String.format("%03d", (id + 1));
                return format;
            }
        } catch (SQLException e) {
            System.out.println("Employee Generate Id Issue..");
        }
        return "001";
    }


    public ArrayList<Employee> getAll() {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM employee");
            ArrayList<Employee> employee = new ArrayList<>();
            while (rst.next()) {
                employee.add(new Employee(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
                        rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9),
                        rst.getString(10), rst.getString(11), rst.getString(12), rst.getString(13)));
            }
            return employee;
        } catch (SQLException e) {
            System.out.println("Get All Employee Issue..");
        }
        return null;
    }

    public boolean delete(int text) {
        try {
            return SQLUtil.execute("DELETE FROM employee WHERE id=?",text);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Delete Employee Issue..");
        }
        return false;
    }

    public ArrayList<Employee> search(String text) {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM employee WHERE id LIKE '%" + text + "%' OR name LIKE '%" + text + "%' OR address LIKE '%" + text + "%' OR " +
                    "contact LIKE '%" + text + "%' OR email LIKE '%" + text + "%' OR dob LIKE '%" + text + "%' OR job_role LIKE '%" + text + "%'");
            ArrayList<Employee> employeeDtos = new ArrayList<>();
            while (rst.next()) {
                employeeDtos.add(new Employee(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
                        rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9),
                        rst.getString(10), rst.getString(11), rst.getString(12), rst.getString(13)));
            }
            return employeeDtos;
        }catch (SQLException e){
            System.out.println("Search Employee Issue..");
        }
        return null;
    }

    public ArrayList<Integer> getAllId() {
        try {
            ResultSet rst = SQLUtil.execute("SELECT id FROM employee");
            ArrayList<Integer> employee = new ArrayList<>();
            while (rst.next()) {
                employee.add(rst.getInt(1));
            }
            return employee;
        }catch (SQLException e){
            System.out.println("Get All Employee Id Issue..");
        }
        return null;
    }

    public String getPeriodDate(String id) {
        try {
            ResultSet resultSet = SQLUtil.execute("SELECT period_date FROM employee WHERE id=?",Integer.parseInt(id));
            if (resultSet.next()) {
                return resultSet.getString("period_date");
            }
        }catch (SQLException e){
            System.out.println("Get Employee periodDate from Id Issue..");
        }
        return null;
    }

    public Employee getAllValues(String nic) {
        try {
            ResultSet rst =  SQLUtil.execute("SELECT * FROM employee WHERE nic=?",nic);
            if (rst.next()) {
                return new Employee(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
                        rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9),
                        rst.getString(10), rst.getString(11), rst.getString(12), rst.getString(13));
            }
        }catch (SQLException e){
            System.out.println("Get Employee From Nic Issue..");
        }
        return null;
    }

    public boolean saveEmployees(int id) {
        try {
            return SQLUtil.execute("INSERT INTO employee (name, address, contact, email, dob, job_role, department, nic, status, hire_date, period, period_date) SELECT name, address, contact, email, dob, job_role, department, nic, status, hire_date, period, period_date FROM eliminate_employee WHERE id = ?",id);
        }catch (SQLException e){
            System.out.println("Replace Eliminate Issue..");
            e.printStackTrace();
        }
        return false;
    }

    public boolean searchFromId(String text) {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM employee WHERE nic=?",text);
            if (rst.next()) {
                return true;
            }
        }catch (SQLException e){
            System.out.println("Search Employee From Nic Issue..");
        }
        return false;
    }

    public boolean update(Employee Dto) {
        try {
            return SQLUtil.execute("UPDATE employee SET name=?, address=?, contact=?, email=?, dob=?, job_role=?, department=?, nic=?, status=?, hire_date=?, period=?, period_date=? WHERE id=?",Dto.getName(),
                    Dto.getAddress(), Dto.getContact(), Dto.getEmail(), Dto.getDob(), Dto.getJobRole(), Dto.getDepartment(), Dto.getNic(), Dto.getStatus(), Dto.getHire(), Dto.getPeriod(), Dto.getPeriodDate(),Dto.getId());
        }catch (SQLException e){
            System.out.println("Employee Update Issue..");
            e.printStackTrace();
        }
        return false;
    }
    public Employee getValues(int selectedItem) {
        try {
            ResultSet rst = SQLUtil.execute("SELECT * FROM employee WHERE id=?",selectedItem);
            if (rst.next()) {
                return new Employee(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6),rst.getString(7),
                        rst.getString(8),rst.getString(9),rst.getString(10),rst.getString(11),rst.getString(12),rst.getString(13));
            }
        }catch (SQLException e){
            System.out.println("Get Values Issue From Employee Salary..");
        }
        return null;
    }
}
