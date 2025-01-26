package lk.ijse.malshanrentshopmanagement.dao.custom;

import lk.ijse.malshanrentshopmanagement.dao.CrudDAO;
import lk.ijse.malshanrentshopmanagement.dto.EmployeeDto;
import lk.ijse.malshanrentshopmanagement.entity.Employee;

import java.util.ArrayList;

public interface EmployeeDAO extends CrudDAO<Employee> {
    ArrayList<Integer> getAllId();
    String getPeriodDate(String id);
    boolean saveEmployees(int id);
    Employee getValues(int selectedItem);
}
