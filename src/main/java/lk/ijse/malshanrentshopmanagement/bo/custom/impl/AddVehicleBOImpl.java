package lk.ijse.malshanrentshopmanagement.bo.custom.impl;

import lk.ijse.malshanrentshopmanagement.bo.custom.AddVehicleBO;
import lk.ijse.malshanrentshopmanagement.dao.DAOFactory;
import lk.ijse.malshanrentshopmanagement.dao.custom.VehicleDAO;
import lk.ijse.malshanrentshopmanagement.dto.VehicleDto;
import lk.ijse.malshanrentshopmanagement.entity.Vehicle;

public class AddVehicleBOImpl implements AddVehicleBO {
    VehicleDAO vehicleDAO = (VehicleDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.VEHICLE);

    @Override
    public String getId() {
        return vehicleDAO.getId();
    }

    @Override
    public VehicleDto getAllValues(String text) {
        Vehicle allVehicle = vehicleDAO.getAllVehicle(text);
        return new VehicleDto(allVehicle.getId(),allVehicle.getBrand(),allVehicle.getModel(),
                allVehicle.getChassie_number(),allVehicle.getColor(),allVehicle.getDate(),
                allVehicle.getPrice(),allVehicle.getRegistration_code());
    }

    @Override
    public boolean save(VehicleDto Dto) {
        return vehicleDAO.save(new Vehicle(Dto.getId(),Dto.getBrand(),Dto.getModel(),
                Dto.getChassie_number(),Dto.getColor(),Dto.getDate(),
                Dto.getPrice(),Dto.getRegistration_code()));
    }

    @Override
    public boolean searchFromId(String id) {
        return vehicleDAO.searchFromId(id);
    }

    @Override
    public boolean update(VehicleDto Dto) {
        return vehicleDAO.update(new Vehicle(Dto.getId(),Dto.getBrand(),Dto.getModel(),
                Dto.getChassie_number(),Dto.getColor(),Dto.getDate(),
                Dto.getPrice(),Dto.getRegistration_code()));
    }
}
