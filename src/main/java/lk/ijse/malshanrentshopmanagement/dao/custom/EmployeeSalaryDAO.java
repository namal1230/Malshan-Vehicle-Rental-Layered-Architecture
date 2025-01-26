package lk.ijse.malshanrentshopmanagement.dao.custom;

import lk.ijse.malshanrentshopmanagement.dao.CrudDAO;
import lk.ijse.malshanrentshopmanagement.dto.EmployeeSalaryDto;
import lk.ijse.malshanrentshopmanagement.entity.EmployeeSalary;

public interface EmployeeSalaryDAO extends CrudDAO<EmployeeSalary> {
    boolean searchEmployeeId(int id);
}
