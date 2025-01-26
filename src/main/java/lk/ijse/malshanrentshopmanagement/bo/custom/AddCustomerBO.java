package lk.ijse.malshanrentshopmanagement.bo.custom;

import lk.ijse.malshanrentshopmanagement.bo.SuperBO;
import lk.ijse.malshanrentshopmanagement.dto.CustomerDto;
import lk.ijse.malshanrentshopmanagement.dto.VehicleDto;

import java.util.ArrayList;

public interface AddCustomerBO extends SuperBO {
    String getCustomerFromId(int id);
    CustomerDto getAllValues(String text);
    boolean save(CustomerDto customerDto);
    String generateId();
    boolean searchFromId(String id);
    boolean update(CustomerDto customerDto);
    ArrayList<Integer> getAllDriversId();
    String getNameDriver(int selectedItem);
    ArrayList<Integer> getAllVehicleId();
    String getBrand(Object selectedItem);
}
