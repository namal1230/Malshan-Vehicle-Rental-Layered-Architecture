package lk.ijse.malshanrentshopmanagement.dao.custom;

import lk.ijse.malshanrentshopmanagement.dao.CrudDAO;
import lk.ijse.malshanrentshopmanagement.dto.DriverDto;
import lk.ijse.malshanrentshopmanagement.entity.Driver;

import java.util.ArrayList;

public interface DriverDAO extends CrudDAO<Driver> {
    ArrayList<Integer> getAllDriversId();
    String getName(int selectedItem);
    boolean deleteDriver(String text);

}
