package lk.ijse.malshanrentshopmanagement.bo.custom;

import lk.ijse.malshanrentshopmanagement.bo.SuperBO;
import lk.ijse.malshanrentshopmanagement.dao.custom.EliminateEmployeeDAO;
import lk.ijse.malshanrentshopmanagement.dto.EliminateEmployeeDto;
import lk.ijse.malshanrentshopmanagement.dto.EmployeeDto;

import java.util.ArrayList;

public interface EliminateEmployeeBO extends SuperBO {
    boolean replaceEliminateEmployee(int id);
    ArrayList<EliminateEmployeeDto> getAll();
    ArrayList<EliminateEmployeeDto> search(String text);
    boolean delete(int text);
    boolean saveEmployees(int id);
}
