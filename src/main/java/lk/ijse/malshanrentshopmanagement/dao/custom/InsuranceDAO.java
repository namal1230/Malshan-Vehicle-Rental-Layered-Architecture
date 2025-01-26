package lk.ijse.malshanrentshopmanagement.dao.custom;

import lk.ijse.malshanrentshopmanagement.dao.CrudDAO;
import lk.ijse.malshanrentshopmanagement.dto.InsuranceDto;
import lk.ijse.malshanrentshopmanagement.entity.Insurance;

public interface InsuranceDAO extends CrudDAO<Insurance> {
    int getInsuranceId();
    boolean delete(String text);
    boolean checkId(String id);
}
