package lk.ijse.malshanrentshopmanagement.dao;

import lk.ijse.malshanrentshopmanagement.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        if (daoFactory==null) {
            daoFactory= new DAOFactory();
        }
        return daoFactory;
    }

    public enum GetType{
        CUSTOMER,CUSTOMER_PAYMENT,DRIVER,ELIMINATE_EMPLOYEE,EMPLOYEE,EMPLOYEE_SALARY,INSURANCE,USER,VEHICLE,VEHICLE_MAINTENANCE,QUERY
    }

    public SuperDAO getDAO(GetType type){
        switch (type){
            case CUSTOMER -> {
                return new CustomerDAOImpl();
            } case CUSTOMER_PAYMENT -> {
                return new CustomerPaymentDAOImpl();
            } case DRIVER -> {
                return new DriverDAOImpl();
            } case ELIMINATE_EMPLOYEE -> {
                return new EliminateEmployeeDAOImpl();
            }  case EMPLOYEE -> {
                return new EmployeeDAOImpl();
            }  case EMPLOYEE_SALARY -> {
                return new EmployeeSalaryDAOImpl();
            }  case INSURANCE -> {
                return new InsuranceDAOImpl();
            }   case USER -> {
                return new UserDAOImpl();
            }   case VEHICLE -> {
                return new VehicleDAOImpl();
            }   case VEHICLE_MAINTENANCE -> {
                return new VehicleMaintenanceDAOImpl();
            }   case QUERY -> {
                return new QueryDAOImpl();
            }default -> {
                return null;
            }
        }
    }
}
