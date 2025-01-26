package lk.ijse.malshanrentshopmanagement.bo.custom.impl;

import lk.ijse.malshanrentshopmanagement.bo.custom.EliminateEmployeeBO;
import lk.ijse.malshanrentshopmanagement.dao.DAOFactory;
import lk.ijse.malshanrentshopmanagement.dao.custom.EliminateEmployeeDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.EmployeeDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.EliminateEmployeeDAOImpl;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.malshanrentshopmanagement.db.DBConnection;
import lk.ijse.malshanrentshopmanagement.dto.EliminateEmployeeDto;
import lk.ijse.malshanrentshopmanagement.dto.EmployeeDto;
import lk.ijse.malshanrentshopmanagement.entity.EliminateEmployee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class EliminateEmployeeBOImpl implements EliminateEmployeeBO {

    EliminateEmployeeDAO eliminateEmployeeDAO = (EliminateEmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.ELIMINATE_EMPLOYEE);
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.EMPLOYEE);
    public boolean replaceEliminateEmployee(int id) {
        try {
            Connection connection = null;
            try {
                connection = DBConnection.getInstance().getConnection();
                connection.setAutoCommit(false);
                boolean isSave = employeeDAO.saveEmployees(id);
                if (isSave) {
                    boolean isDelete = eliminateEmployeeDAO.delete(id);
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
                System.out.println("Transaction Eliminate Employee Issue..");
                connection.rollback();
            } finally {
                if (connection != null) {
                    connection.setAutoCommit(true);
                }
            }
        }catch (SQLException e){
            System.out.println("Transaction Issue.");
        }
        return false;
    }

    @Override
    public ArrayList<EliminateEmployeeDto> getAll() {
        ArrayList<EliminateEmployee> all = eliminateEmployeeDAO.getAll();
        ArrayList<EliminateEmployeeDto> eliminateEmployeeDtos = new ArrayList<>();
        for (EliminateEmployee eliminateEmployee:all){
            eliminateEmployeeDtos.add(new EliminateEmployeeDto(eliminateEmployee.getId(),
                    eliminateEmployee.getName(),eliminateEmployee.getAddress(),eliminateEmployee.getContact(),
                    eliminateEmployee.getEmail(),eliminateEmployee.getDob(),eliminateEmployee.getJobRole(),
                    eliminateEmployee.getDepartment(),eliminateEmployee.getNic(),eliminateEmployee.getStatus()
                    ,eliminateEmployee.getHireDate(),eliminateEmployee.getPeriod(),
                    eliminateEmployee.getPeriodDate()));
        }
        return eliminateEmployeeDtos;
    }

    @Override
    public ArrayList<EliminateEmployeeDto> search(String text) {
        ArrayList<EliminateEmployee> search = eliminateEmployeeDAO.search(text);
        ArrayList<EliminateEmployeeDto> eliminateEmployeeDtos = new ArrayList<>();
        for (EliminateEmployee eliminateEmployee:search){
            eliminateEmployeeDtos.add(new EliminateEmployeeDto(eliminateEmployee.getId(),
                    eliminateEmployee.getName(),eliminateEmployee.getAddress(),eliminateEmployee.getContact(),
                    eliminateEmployee.getEmail(),eliminateEmployee.getDob(),eliminateEmployee.getJobRole(),
                    eliminateEmployee.getDepartment(),eliminateEmployee.getNic(),eliminateEmployee.getStatus()
                    ,eliminateEmployee.getHireDate(),eliminateEmployee.getPeriod(),
                    eliminateEmployee.getPeriodDate()));
        }
        return eliminateEmployeeDtos;
    }

    @Override
    public boolean delete(int text) {
        return eliminateEmployeeDAO.delete(text);
    }

    @Override
    public boolean saveEmployees(int id) {
        return employeeDAO.saveEmployees(id);
    }
}
