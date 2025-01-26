package lk.ijse.malshanrentshopmanagement.bo.custom.impl;

import lk.ijse.malshanrentshopmanagement.bo.custom.VehicleBO;
import lk.ijse.malshanrentshopmanagement.dao.DAOFactory;
import lk.ijse.malshanrentshopmanagement.dao.custom.VehicleDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.VehicleDAOImpl;
import lk.ijse.malshanrentshopmanagement.dto.VehicleDto;
import lk.ijse.malshanrentshopmanagement.entity.Vehicle;

import java.util.ArrayList;

public class VehicleBOImpl implements VehicleBO {
    VehicleDAO vehicleDAO = (VehicleDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.VEHICLE);
    @Override
    public ArrayList<VehicleDto> getAll() {
        ArrayList<Vehicle> all = vehicleDAO.getAll();
        ArrayList<VehicleDto> vehicleDtos = new ArrayList<>();
        for (Vehicle vehicle:all){
            vehicleDtos.add(new VehicleDto(vehicle.getId(),vehicle.getBrand(),vehicle.getModel(),
                    vehicle.getChassie_number(),vehicle.getColor(),vehicle.getDate(),vehicle.getPrice(),
                    vehicle.getRegistration_code()));
        }
        return vehicleDtos;
    }

    @Override
    public ArrayList<VehicleDto> search(String text) {
        ArrayList<Vehicle> search = vehicleDAO.search(text);
        ArrayList<VehicleDto> vehicleDtos = new ArrayList<>();
        for (Vehicle vehicle:search){
            vehicleDtos.add(new VehicleDto(vehicle.getId(),vehicle.getBrand(),vehicle.getModel(),
                    vehicle.getChassie_number(),vehicle.getColor(),vehicle.getDate(),vehicle.getPrice(),
                    vehicle.getRegistration_code()));
        }
        return vehicleDtos;
    }

    @Override
    public boolean deleteVehicle(VehicleDto vehicleDto) {
        return vehicleDAO.deleteVehicle(new Vehicle(vehicleDto.getId(),vehicleDto.getBrand(),
                vehicleDto.getModel(),vehicleDto.getChassie_number(),vehicleDto.getColor(),
                vehicleDto.getDate(),vehicleDto.getPrice(),vehicleDto.getRegistration_code()));
    }
}
