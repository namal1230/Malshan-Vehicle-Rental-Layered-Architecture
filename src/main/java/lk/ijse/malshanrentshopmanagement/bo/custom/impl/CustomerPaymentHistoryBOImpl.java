package lk.ijse.malshanrentshopmanagement.bo.custom.impl;

import lk.ijse.malshanrentshopmanagement.bo.custom.CustomerPaymentHistoryBO;
import lk.ijse.malshanrentshopmanagement.dao.DAOFactory;
import lk.ijse.malshanrentshopmanagement.dao.custom.CustomerPaymentDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.CustomerPaymentDAOImpl;
import lk.ijse.malshanrentshopmanagement.dto.CustomerPaymentDto;
import lk.ijse.malshanrentshopmanagement.entity.CustomerPayment;

import java.util.ArrayList;

public class CustomerPaymentHistoryBOImpl implements CustomerPaymentHistoryBO {

   CustomerPaymentDAO customerPaymentDAO = (CustomerPaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.CUSTOMER_PAYMENT);

    @Override
    public ArrayList<CustomerPaymentDto> getAll() {
        ArrayList<CustomerPayment> all = customerPaymentDAO.getAll();
        ArrayList<CustomerPaymentDto> customerPaymentDtos = new ArrayList<>();
        for (CustomerPayment customerPayment:all){
            customerPaymentDtos.add(new CustomerPaymentDto( customerPayment.getCustomerId(),customerPayment.getMethod(),customerPayment.getCardNumber(),
                    customerPayment.getVehicleId(),customerPayment.getRentalPeriod(),customerPayment.getLocationDistance(),customerPayment.getDriverId()));
        }
        return customerPaymentDtos;
    }

    @Override
    public ArrayList<CustomerPaymentDto> search(String text) {
        ArrayList<CustomerPayment> search = customerPaymentDAO.search(text);
        ArrayList<CustomerPaymentDto> customerPaymentDtos = new ArrayList<>();
        for (CustomerPayment customerPayment:search){
            customerPaymentDtos.add(new CustomerPaymentDto( customerPayment.getCustomerId(),customerPayment.getMethod(),customerPayment.getCardNumber(),
                    customerPayment.getVehicleId(),customerPayment.getRentalPeriod(),customerPayment.getLocationDistance(),customerPayment.getDriverId()));
        }
        return customerPaymentDtos;
    }
}
