package lk.ijse.malshanrentshopmanagement.bo.custom;

import lk.ijse.malshanrentshopmanagement.bo.SuperBO;
import lk.ijse.malshanrentshopmanagement.dto.EmployeeDto;

public interface AddEmployeeBO extends SuperBO {
    EmployeeDto getAllValues(String text);
    boolean save(EmployeeDto Dto);
    String generateId();
    boolean searchFromId(String id);
    boolean update(EmployeeDto Dto);
}
