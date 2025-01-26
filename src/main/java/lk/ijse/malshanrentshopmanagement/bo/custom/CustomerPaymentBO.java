package lk.ijse.malshanrentshopmanagement.bo.custom;

import lk.ijse.malshanrentshopmanagement.bo.SuperBO;
import lk.ijse.malshanrentshopmanagement.dto.CustomerPaymentDto;

import java.util.ArrayList;

public interface CustomerPaymentBO extends SuperBO {
    boolean savePayment(CustomerPaymentDto Dto);
    ArrayList<Integer> loadId();
    boolean save(CustomerPaymentDto Dto);
    String getCustomerFromId(int id);
    ArrayList<Integer> getAllDriversId();
    String getName(int selectedItem);
    boolean delete(int text);
    ArrayList<Integer> getAllVehicleId();
    String getBrand(Object selectedItem);

    boolean deleteVehicle(int vehicleId);
}
