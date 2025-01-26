package lk.ijse.malshanrentshopmanagement.bo.custom;

import lk.ijse.malshanrentshopmanagement.bo.SuperBO;
import lk.ijse.malshanrentshopmanagement.dto.MaintenanceDto;

import java.util.ArrayList;

public interface VehicleMaintenanceBO extends SuperBO {
    int getId();
    ArrayList<MaintenanceDto> getAll();
    boolean save(MaintenanceDto Dto);
    ArrayList<MaintenanceDto> search(String text);
    boolean searchFromId(String id);
    boolean update(MaintenanceDto Dto);
    boolean delete(int text);
}
