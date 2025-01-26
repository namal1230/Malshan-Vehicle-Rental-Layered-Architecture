package lk.ijse.malshanrentshopmanagement.bo;

import lk.ijse.malshanrentshopmanagement.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        if (boFactory==null) {
            boFactory= new BOFactory();
        }
        return boFactory;
    }

    public enum GetType{
        CUSTOMER,ADD_EMPLOYEE,ADD_VEHICLE,CUSTOMER_MANAGEMENT,CUSTOMER_PAYMENT,
        CUSTOMER_PAYMENT_HISTORY,DRIVER,ELIMINATE_EMPLOYEE,EMPLOYEE,EMPLOYEE_SALARY,INSURANCE,LOGIN,
        VEHICLE,VEHICLE_MAINTENANCE,VEHICLE_SUMMARY
    }

   public SuperBO getBO(GetType type){
        switch (type){
            case CUSTOMER -> {
                return new AddCustomerBOImpl();
            }case ADD_EMPLOYEE -> {
                return new AddEmployeeBOImpl();
            }case ADD_VEHICLE ->  {
                return new AddVehicleBOImpl();
            }case CUSTOMER_MANAGEMENT -> {
                return new CustomerManagementBOImpl();
            }case CUSTOMER_PAYMENT -> {
                return new CustomerPaymentBOImpl();
            }case CUSTOMER_PAYMENT_HISTORY -> {
                return new CustomerPaymentHistoryBOImpl();
            }case DRIVER -> {
                return new DriverBOImpl();
            }case ELIMINATE_EMPLOYEE -> {
                return new EliminateEmployeeBOImpl();
            }case EMPLOYEE -> {
                return new EmployeeBOImpl();
            }case EMPLOYEE_SALARY -> {
                return new EmployeeSalaryBOImpl();
            }case INSURANCE -> {
                return new InsuranceBOImpl();
            }case LOGIN -> {
                return new LoginBOImpl();
            }case VEHICLE -> {
                return new VehicleBOImpl();
            }case VEHICLE_MAINTENANCE -> {
                return new VehicleMaintenanceBOImpl();
            }case VEHICLE_SUMMARY -> {
                return new VehicleSummaryBOImpl();
            }default -> {
                return null;
            }
        }
   }
}
