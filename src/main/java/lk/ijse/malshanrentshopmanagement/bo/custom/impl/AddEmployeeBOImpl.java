package lk.ijse.malshanrentshopmanagement.bo.custom.impl;
import lk.ijse.malshanrentshopmanagement.bo.custom.AddEmployeeBO;
import lk.ijse.malshanrentshopmanagement.dao.DAOFactory;
import lk.ijse.malshanrentshopmanagement.dao.custom.EmployeeDAO;
import lk.ijse.malshanrentshopmanagement.dto.EmployeeDto;
import lk.ijse.malshanrentshopmanagement.entity.Employee;

public class AddEmployeeBOImpl implements AddEmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.EMPLOYEE);

    @Override
    public EmployeeDto getAllValues(String text) {
        Employee allValues = employeeDAO.getAllValues(text);
        return new EmployeeDto(allValues.getId(),allValues.getName(),allValues.getAddress(),
                allValues.getContact(), allValues.getEmail(),allValues.getDob(),allValues.getJobRole(),
                allValues.getDepartment(),allValues.getNic(),allValues.getStatus(),allValues.getHire(),
                allValues.getPeriod(),allValues.getPeriodDate());
    }

    @Override
    public boolean save(EmployeeDto Dto) {
        return employeeDAO.save(new Employee(Dto.getId(),Dto.getName(),Dto.getAddress(),
                Dto.getContact(), Dto.getEmail(),Dto.getDob(),Dto.getJobRole(),
                Dto.getDepartment(),Dto.getNic(),Dto.getStatus(),Dto.getHire(),
                Dto.getPeriod(),Dto.getPeriodDate()));
    }

    @Override
    public String generateId() {
        return employeeDAO.generateId();
    }

    @Override
    public boolean searchFromId(String id) {
        return employeeDAO.searchFromId(id);
    }

    @Override
    public boolean update(EmployeeDto Dto) {
        return employeeDAO.update(new Employee(Dto.getId(),Dto.getName(),Dto.getAddress(),
                Dto.getContact(), Dto.getEmail(),Dto.getDob(),Dto.getJobRole(),
                Dto.getDepartment(),Dto.getNic(),Dto.getStatus(),Dto.getHire(),
                Dto.getPeriod(),Dto.getPeriodDate()));
    }
}
