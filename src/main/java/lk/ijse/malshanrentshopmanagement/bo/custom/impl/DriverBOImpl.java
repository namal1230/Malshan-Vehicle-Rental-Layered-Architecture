package lk.ijse.malshanrentshopmanagement.bo.custom.impl;

import lk.ijse.malshanrentshopmanagement.bo.custom.DriverBO;
import lk.ijse.malshanrentshopmanagement.dao.DAOFactory;
import lk.ijse.malshanrentshopmanagement.dao.custom.DriverDAO;
import lk.ijse.malshanrentshopmanagement.dto.DriverDto;
import lk.ijse.malshanrentshopmanagement.entity.Driver;

import java.util.ArrayList;

public class DriverBOImpl implements DriverBO {

    DriverDAO driverDAO = (DriverDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.DRIVER);
    @Override
    public DriverDto getAllValues(String text) {
        Driver allValues = driverDAO.getAllValues(text);
        return new DriverDto(allValues.getId(),allValues.getName(),allValues.getAddress(),
                allValues.getContact(),allValues.getEmail(),allValues.getDob(),allValues.getNic(),
                allValues.getLicense_number(),allValues.getLicense_exp(),allValues.getLicense_type(),
                allValues.getMedical(),allValues.getStatus());
    }

    @Override
    public ArrayList<DriverDto> getAll() {
        ArrayList<Driver> all = driverDAO.getAll();
        ArrayList<DriverDto> driverDtos = new ArrayList<>();
        for (Driver driver:all){
            driverDtos.add(new DriverDto(driver.getId(),driver.getName(),driver.getAddress(),
                    driver.getContact(),driver.getEmail(),driver.getDob(),driver.getNic(),
                    driver.getLicense_number(),driver.getLicense_exp(),driver.getLicense_type(),
                    driver.getMedical(),driver.getStatus()));
        }
        return driverDtos;
    }

    @Override
    public boolean save(DriverDto Dto) {
        return driverDAO.save(new Driver(Dto.getId(),Dto.getName(),Dto.getAddress(),
                Dto.getContact(),Dto.getEmail(),Dto.getDob(),Dto.getNic(),
                Dto.getLicense_number(),Dto.getLicense_exp(),Dto.getLicense_type(),
                Dto.getMedical(),Dto.getStatus()));
    }

    @Override
    public ArrayList<DriverDto> search(String text) {
        ArrayList<Driver> search = driverDAO.search(text);
        ArrayList<DriverDto> driverDtos = new ArrayList<>();
        for (Driver driver:search){
            driverDtos.add(new DriverDto(driver.getId(),driver.getName(),driver.getAddress(),
                    driver.getContact(),driver.getEmail(),driver.getDob(),driver.getNic(),
                    driver.getLicense_number(),driver.getLicense_exp(),driver.getLicense_type(),
                    driver.getMedical(),driver.getStatus()));
        }
        return driverDtos;
    }

    @Override
    public boolean searchFromId(String id) {
        return driverDAO.searchFromId(id);
    }

    @Override
    public boolean update(DriverDto Dto) {
        return driverDAO.update(new Driver(Dto.getId(),Dto.getName(),Dto.getAddress(),
                Dto.getContact(),Dto.getEmail(),Dto.getDob(),Dto.getNic(),
                Dto.getLicense_number(),Dto.getLicense_exp(),Dto.getLicense_type(),
                Dto.getMedical(),Dto.getStatus()));
    }

    @Override
    public boolean deleteDriver(String text) {
        return driverDAO.deleteDriver(text);
    }
}
