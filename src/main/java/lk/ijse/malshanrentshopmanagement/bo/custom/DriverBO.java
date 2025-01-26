package lk.ijse.malshanrentshopmanagement.bo.custom;

import lk.ijse.malshanrentshopmanagement.bo.SuperBO;
import lk.ijse.malshanrentshopmanagement.dto.DriverDto;

import java.util.ArrayList;

public interface DriverBO extends SuperBO {
    DriverDto getAllValues(String text);
    ArrayList<DriverDto> getAll();
    boolean save(DriverDto Dto);
    ArrayList<DriverDto> search(String text);
    boolean searchFromId(String id);
    boolean update(DriverDto Dto);
    boolean deleteDriver(String text);
}
