package lk.ijse.malshanrentshopmanagement.dao.custom;

import lk.ijse.malshanrentshopmanagement.dao.CrudDAO;
import lk.ijse.malshanrentshopmanagement.dto.CustomerDto;
import lk.ijse.malshanrentshopmanagement.entity.Customer;

public interface CustomerDAO extends CrudDAO<Customer> {
    String getCustomerFromId(int id);
}
