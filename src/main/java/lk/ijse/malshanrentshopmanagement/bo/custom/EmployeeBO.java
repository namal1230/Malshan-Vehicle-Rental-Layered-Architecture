package lk.ijse.malshanrentshopmanagement.bo.custom;

import lk.ijse.malshanrentshopmanagement.bo.SuperBO;
import lk.ijse.malshanrentshopmanagement.dto.EmployeeDto;

import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {
    boolean deleteEmployee(int id);
    ArrayList<EmployeeDto> getAll();
    ArrayList<EmployeeDto> search(String text);
    boolean delete(int text);
    boolean saveEliminateEmployee(int id);
}
