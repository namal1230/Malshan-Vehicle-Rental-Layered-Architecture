package lk.ijse.malshanrentshopmanagement.bo.custom;

import lk.ijse.malshanrentshopmanagement.bo.SuperBO;
import lk.ijse.malshanrentshopmanagement.dto.VehicleSummaryDto;

import java.util.ArrayList;

public interface VehicleSummaryBO extends SuperBO {
    ArrayList<VehicleSummaryDto> getAll();
}
