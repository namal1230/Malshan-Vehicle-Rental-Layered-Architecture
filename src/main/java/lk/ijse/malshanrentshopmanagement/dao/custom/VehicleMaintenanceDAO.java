package lk.ijse.malshanrentshopmanagement.dao.custom;

import lk.ijse.malshanrentshopmanagement.dao.CrudDAO;
import lk.ijse.malshanrentshopmanagement.dto.MaintenanceDto;
import lk.ijse.malshanrentshopmanagement.entity.VehicleMaintenance;

public interface VehicleMaintenanceDAO extends CrudDAO<VehicleMaintenance> {
    int getId();
}
