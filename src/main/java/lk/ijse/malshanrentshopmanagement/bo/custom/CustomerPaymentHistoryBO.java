package lk.ijse.malshanrentshopmanagement.bo.custom;

import lk.ijse.malshanrentshopmanagement.bo.SuperBO;
import lk.ijse.malshanrentshopmanagement.dao.custom.CustomerPaymentDAO;
import lk.ijse.malshanrentshopmanagement.dto.CustomerPaymentDto;

import java.util.ArrayList;

public interface CustomerPaymentHistoryBO extends SuperBO {
    ArrayList<CustomerPaymentDto> getAll();
    ArrayList<CustomerPaymentDto> search(String text);
}
