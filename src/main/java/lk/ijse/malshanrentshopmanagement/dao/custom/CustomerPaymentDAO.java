package lk.ijse.malshanrentshopmanagement.dao.custom;

import lk.ijse.malshanrentshopmanagement.dao.CrudDAO;
import lk.ijse.malshanrentshopmanagement.dto.CustomerPaymentDto;
import lk.ijse.malshanrentshopmanagement.entity.CustomerPayment;

import java.util.ArrayList;

public interface CustomerPaymentDAO extends CrudDAO<CustomerPayment> {
    ArrayList<Integer> loadId();
}
