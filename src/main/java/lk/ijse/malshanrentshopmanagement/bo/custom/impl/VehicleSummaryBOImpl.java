package lk.ijse.malshanrentshopmanagement.bo.custom.impl;

import lk.ijse.malshanrentshopmanagement.bo.custom.VehicleSummaryBO;
import lk.ijse.malshanrentshopmanagement.dao.DAOFactory;
import lk.ijse.malshanrentshopmanagement.dao.custom.QueryDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.QueryDAOImpl;
import lk.ijse.malshanrentshopmanagement.dto.VehicleSummaryDto;
import lk.ijse.malshanrentshopmanagement.entity.VehicleSummary;

import java.util.ArrayList;

public class VehicleSummaryBOImpl implements VehicleSummaryBO {
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.QUERY);
    @Override
    public ArrayList<VehicleSummaryDto> getAll() {
        ArrayList<VehicleSummary> all = queryDAO.getAll();
        ArrayList<VehicleSummaryDto> vehicleSummaryDtos = new ArrayList<>();
        for (VehicleSummary vehicleSummary:all){
            vehicleSummaryDtos.add(new VehicleSummaryDto(vehicleSummary.getBrand(),vehicleSummary.getModel(),
                    vehicleSummary.getChassie_number(),vehicleSummary.getColor(),vehicleSummary.getRegister_code(),vehicleSummary.getProvider(),vehicleSummary.getPolicynumber(),
                    vehicleSummary.getPolicyType(),vehicleSummary.getMaintenanceType()));
        }
        return vehicleSummaryDtos;
    }
}
