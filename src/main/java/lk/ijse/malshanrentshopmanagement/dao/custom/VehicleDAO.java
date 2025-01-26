package lk.ijse.malshanrentshopmanagement.dao.custom;

import lk.ijse.malshanrentshopmanagement.dao.CrudDAO;
import lk.ijse.malshanrentshopmanagement.dto.VehicleDto;
import lk.ijse.malshanrentshopmanagement.entity.Vehicle;

import java.util.ArrayList;

public interface VehicleDAO extends CrudDAO<Vehicle> {
    String getId();
    boolean deleteVehicle(Vehicle vehicle);
    ArrayList<Integer> getAllVehicleId();
    String getBrand(Object selectedItem);
    Vehicle getAllVehicle(String chassieNumber);
}
