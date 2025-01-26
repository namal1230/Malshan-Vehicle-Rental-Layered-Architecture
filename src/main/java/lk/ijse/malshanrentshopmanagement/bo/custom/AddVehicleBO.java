package lk.ijse.malshanrentshopmanagement.bo.custom;

import lk.ijse.malshanrentshopmanagement.bo.SuperBO;
import lk.ijse.malshanrentshopmanagement.dto.VehicleDto;

public interface AddVehicleBO extends SuperBO {
    String getId();
    VehicleDto getAllValues(String text);
    boolean save(VehicleDto Dto);
    boolean searchFromId(String id);
    boolean update(VehicleDto Dto);
}
