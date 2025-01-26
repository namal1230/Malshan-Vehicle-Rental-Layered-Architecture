package lk.ijse.malshanrentshopmanagement.bo.custom;

import lk.ijse.malshanrentshopmanagement.bo.SuperBO;
import lk.ijse.malshanrentshopmanagement.dto.VehicleDto;

import java.util.ArrayList;

public interface VehicleBO extends SuperBO {
    ArrayList<VehicleDto> getAll();
    ArrayList<VehicleDto> search(String text);
    boolean deleteVehicle(VehicleDto vehicleDto);
}
