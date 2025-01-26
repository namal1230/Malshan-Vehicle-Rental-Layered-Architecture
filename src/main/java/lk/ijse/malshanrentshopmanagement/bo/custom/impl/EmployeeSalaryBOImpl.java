package lk.ijse.malshanrentshopmanagement.bo.custom.impl;

import lk.ijse.malshanrentshopmanagement.bo.custom.EmployeeSalaryBO;
import lk.ijse.malshanrentshopmanagement.dao.DAOFactory;
import lk.ijse.malshanrentshopmanagement.dao.custom.EmployeeDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.EmployeeSalaryDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.EmployeeSalaryDAOImpl;
import lk.ijse.malshanrentshopmanagement.dto.EmployeeDto;
import lk.ijse.malshanrentshopmanagement.dto.EmployeeSalaryDto;
import lk.ijse.malshanrentshopmanagement.entity.Employee;
import lk.ijse.malshanrentshopmanagement.entity.EmployeeSalary;

import java.util.ArrayList;

public class EmployeeSalaryBOImpl implements EmployeeSalaryBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.EMPLOYEE);
    EmployeeSalaryDAO employeeSalaryDAO = (EmployeeSalaryDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.EMPLOYEE_SALARY);

    @Override
    public ArrayList<EmployeeSalaryDto> getAll() {
        ArrayList<EmployeeSalary> all = employeeSalaryDAO.getAll();
        ArrayList<EmployeeSalaryDto> employeeSalaryDtos = new ArrayList<>();
        for (EmployeeSalary employeeSalary:all){
            employeeSalaryDtos.add(new EmployeeSalaryDto(employeeSalary.getId(),employeeSalary.getSalary(),
                    employeeSalary.getBank_account(),employeeSalary.getTax(),
                    employeeSalary.getProbation_period(),employeeSalary.getDate()));
        }
        return employeeSalaryDtos;
    }

    @Override
    public boolean save(EmployeeSalaryDto Dto) {
        return employeeSalaryDAO.save(new EmployeeSalary(Dto.getId(),Dto.getSalary(),
                Dto.getBank_account(),Dto.getTax(),
                Dto.getProbation_period(),Dto.getDate()));
    }

    @Override
    public ArrayList<EmployeeSalaryDto> search(String text) {
        ArrayList<EmployeeSalary> search = employeeSalaryDAO.search(text);
        ArrayList<EmployeeSalaryDto> employeeSalaryDtos = new ArrayList<>();
        for (EmployeeSalary employeeSalary:search){
            employeeSalaryDtos.add(new EmployeeSalaryDto(employeeSalary.getId(),employeeSalary.getSalary(),
                    employeeSalary.getBank_account(),employeeSalary.getTax(),
                    employeeSalary.getProbation_period(),employeeSalary.getDate()));
        }
        return employeeSalaryDtos;
    }

    @Override
    public boolean delete(int text) {
        return employeeSalaryDAO.delete(text);
    }

    @Override
    public ArrayList<Integer> getAllId() {
        return employeeDAO.getAllId();
    }

    @Override
    public EmployeeDto getValues(int selectedItem) {
        Employee values = employeeDAO.getValues(selectedItem);
        return new EmployeeDto(values.getId(),values.getName(),values.getAddress(),
                values.getContact(),values.getEmail(),values.getDob(),values.getJobRole(),
                values.getDepartment(),values.getNic(),values.getStatus(),values.getHire(),
                values.getPeriod(),values.getPeriodDate());
    }
}
