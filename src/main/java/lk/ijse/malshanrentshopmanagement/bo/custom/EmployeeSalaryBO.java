package lk.ijse.malshanrentshopmanagement.bo.custom;

import lk.ijse.malshanrentshopmanagement.bo.SuperBO;
import lk.ijse.malshanrentshopmanagement.dto.EmployeeDto;
import lk.ijse.malshanrentshopmanagement.dto.EmployeeSalaryDto;

import java.util.ArrayList;

public interface EmployeeSalaryBO extends SuperBO {

    ArrayList<EmployeeSalaryDto> getAll();
    boolean save(EmployeeSalaryDto Dto);
    ArrayList<EmployeeSalaryDto> search(String text);
    boolean delete(int text);
    ArrayList<Integer> getAllId();
    EmployeeDto getValues(int selectedItem);
}
