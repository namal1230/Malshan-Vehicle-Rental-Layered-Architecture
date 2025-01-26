package lk.ijse.malshanrentshopmanagement.bo.custom.impl;

import lk.ijse.malshanrentshopmanagement.bo.custom.CustomerManagementBO;
import lk.ijse.malshanrentshopmanagement.dao.DAOFactory;
import lk.ijse.malshanrentshopmanagement.dao.custom.CustomerDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.malshanrentshopmanagement.dto.CustomerDto;
import lk.ijse.malshanrentshopmanagement.entity.Customer;

import java.util.ArrayList;

public class CustomerManagementBOImpl implements CustomerManagementBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.CUSTOMER);

    @Override
    public ArrayList<CustomerDto> getAll() {
        ArrayList<Customer> all = customerDAO.getAll();
        ArrayList<CustomerDto> customers = new ArrayList<>();
        for (Customer customerDto:all){
            customers.add(new CustomerDto(customerDto.getId(),customerDto.getName(),customerDto.getAddress(),
                    customerDto.getContact(),customerDto.getNic(),customerDto.getDob(),customerDto.getEmail(),
                    customerDto.getDriverId(),customerDto.getLicen_number(),customerDto.getVehicleId(),
                    customerDto.getDate()));
        }
        return customers;
    }

    @Override
    public ArrayList<CustomerDto> search(String text) {
        ArrayList<Customer> search = customerDAO.search(text);
        ArrayList<CustomerDto> customers = new ArrayList<>();
        for (Customer customerDto:search){
            customers.add(new CustomerDto(customerDto.getId(),customerDto.getName(),customerDto.getAddress(),
                    customerDto.getContact(),customerDto.getNic(),customerDto.getDob(),customerDto.getEmail(),
                    customerDto.getDriverId(),customerDto.getLicen_number(),customerDto.getVehicleId(),
                    customerDto.getDate()));
        }
        return customers;
    }

    @Override
    public boolean delete(int text) {
        return customerDAO.delete(text);
    }
}
