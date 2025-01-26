package lk.ijse.malshanrentshopmanagement.dao.custom;

import lk.ijse.malshanrentshopmanagement.dao.SuperDAO;
import lk.ijse.malshanrentshopmanagement.dto.VehicleSummaryDto;
import lk.ijse.malshanrentshopmanagement.entity.VehicleSummary;

import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    ArrayList<VehicleSummary> getAll();

}
