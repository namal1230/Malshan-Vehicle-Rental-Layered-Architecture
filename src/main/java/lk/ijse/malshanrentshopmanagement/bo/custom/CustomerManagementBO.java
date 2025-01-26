package lk.ijse.malshanrentshopmanagement.bo.custom;

import lk.ijse.malshanrentshopmanagement.bo.SuperBO;
import lk.ijse.malshanrentshopmanagement.dto.CustomerDto;

import java.util.ArrayList;

public interface CustomerManagementBO extends SuperBO {
    ArrayList<CustomerDto> getAll();
    ArrayList<CustomerDto> search(String text);
    boolean delete(int text);
}
