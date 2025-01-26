package lk.ijse.malshanrentshopmanagement.bo.custom.impl;

import lk.ijse.malshanrentshopmanagement.bo.custom.EmployeeBO;
import lk.ijse.malshanrentshopmanagement.dao.DAOFactory;
import lk.ijse.malshanrentshopmanagement.dao.custom.EliminateEmployeeDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.EmployeeDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.EliminateEmployeeDAOImpl;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.malshanrentshopmanagement.db.DBConnection;
import lk.ijse.malshanrentshopmanagement.dto.EmployeeDto;
import lk.ijse.malshanrentshopmanagement.entity.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.EMPLOYEE);
    EliminateEmployeeDAO eliminateEmployeeDAO = (EliminateEmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.ELIMINATE_EMPLOYEE);
    public boolean deleteEmployee(int id) {
        try {
            Connection connection = null;
            try {
                connection = DBConnection.getInstance().getConnection();
                connection.setAutoCommit(false);
                boolean isSave = eliminateEmployeeDAO.saveEliminateEmployee(id);
                if (isSave) {
                    boolean isDelete = employeeDAO.delete(id);
                    if (isDelete) {
                        connection.commit();
                        return true;
                    } else {
                        connection.rollback();
                    }
                } else {
                    connection.rollback();
                }
            } catch (SQLException e) {
                System.out.println("Eliminate Employee TransAction Issue..");
                if (connection != null) {
                    connection.rollback();
                }
            } finally {
                if (connection != null) {
                    connection.setAutoCommit(true);
                }
            }
        }catch (SQLException e){
            System.out.println("Transaction Issue..");
        }
        return false;
    }

    @Override
    public ArrayList<EmployeeDto> getAll() {
        ArrayList<Employee> all = employeeDAO.getAll();
        ArrayList<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee employee:all){
            employeeDtos.add(new EmployeeDto(employee.getId(),employee.getName(),employee.getAddress(),
                    employee.getContact(),employee.getEmail(),employee.getDob(),employee.getJobRole(),
                    employee.getDepartment(),employee.getNic(),employee.getStatus(),employee.getHire(),
                    employee.getPeriod(),employee.getPeriodDate()));
        }
        return employeeDtos;
    }

    @Override
    public ArrayList<EmployeeDto> search(String text) {
        ArrayList<Employee> search = employeeDAO.search(text);
        ArrayList<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee employee:search){
            employeeDtos.add(new EmployeeDto(employee.getId(),employee.getName(),employee.getAddress(),
                    employee.getContact(),employee.getEmail(),employee.getDob(),employee.getJobRole(),
                    employee.getDepartment(),employee.getNic(),employee.getStatus(),employee.getHire(),
                    employee.getPeriod(),employee.getPeriodDate()));
        }
        return employeeDtos;
    }

    @Override
    public boolean delete(int text) {
        return employeeDAO.delete(text);
    }

    @Override
    public boolean saveEliminateEmployee(int id) {
        return eliminateEmployeeDAO.saveEliminateEmployee(id);
    }
}
