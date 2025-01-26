package lk.ijse.malshanrentshopmanagement.bo.custom.impl;

import lk.ijse.malshanrentshopmanagement.bo.custom.VehicleMaintenanceBO;
import lk.ijse.malshanrentshopmanagement.dao.DAOFactory;
import lk.ijse.malshanrentshopmanagement.dao.custom.VehicleMaintenanceDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.VehicleMaintenanceDAOImpl;
import lk.ijse.malshanrentshopmanagement.dto.MaintenanceDto;
import lk.ijse.malshanrentshopmanagement.entity.VehicleMaintenance;

import java.util.ArrayList;

public class VehicleMaintenanceBOImpl implements VehicleMaintenanceBO {
    VehicleMaintenanceDAO vehicleMaintenanceDAO = (VehicleMaintenanceDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.VEHICLE_MAINTENANCE);

    @Override
    public int getId() {
        return vehicleMaintenanceDAO.getId();
    }

    @Override
    public ArrayList<MaintenanceDto> getAll() {
        ArrayList<VehicleMaintenance> all = vehicleMaintenanceDAO.getAll();
        ArrayList<MaintenanceDto> maintenanceDtos = new ArrayList<>();
        for (VehicleMaintenance vehicleMaintenance:all){
            maintenanceDtos.add(new MaintenanceDto(vehicleMaintenance.getId(),
                    vehicleMaintenance.getVehicle_chassis(),vehicleMaintenance.getMaintenance_type(),
                    vehicleMaintenance.getLast_maintenance(),vehicleMaintenance.getNext_maintenance(),
                    vehicleMaintenance.getRepairCost()));
        }
        return maintenanceDtos;
    }

    @Override
    public boolean save(MaintenanceDto Dto) {
        return vehicleMaintenanceDAO.save(new VehicleMaintenance(Dto.getId(),
                Dto.getVehicle_chassis(),Dto.getMaintenance_type(),
                Dto.getLast_maintenance(),Dto.getNext_maintenance(),
                Dto.getRepairCost()));
    }

    @Override
    public ArrayList<MaintenanceDto> search(String text) {
        ArrayList<VehicleMaintenance> search = vehicleMaintenanceDAO.search(text);
        ArrayList<MaintenanceDto> maintenanceDtos = new ArrayList<>();
        for (VehicleMaintenance vehicleMaintenance:search){
            maintenanceDtos.add(new MaintenanceDto(vehicleMaintenance.getId(),
                    vehicleMaintenance.getVehicle_chassis(),vehicleMaintenance.getMaintenance_type(),
                    vehicleMaintenance.getLast_maintenance(),vehicleMaintenance.getNext_maintenance(),
                    vehicleMaintenance.getRepairCost()));
        }
        return maintenanceDtos;
    }

    @Override
    public boolean searchFromId(String id) {
        return vehicleMaintenanceDAO.searchFromId(id);
    }

    @Override
    public boolean update(MaintenanceDto Dto) {
        return vehicleMaintenanceDAO.update(new VehicleMaintenance(Dto.getId(),
                Dto.getVehicle_chassis(),Dto.getMaintenance_type(),
                Dto.getLast_maintenance(),Dto.getNext_maintenance(),
                Dto.getRepairCost()));
    }

    @Override
    public boolean delete(int text) {
        return vehicleMaintenanceDAO.delete(text);
    }
}
