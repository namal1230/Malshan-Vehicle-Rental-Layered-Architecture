package lk.ijse.malshanrentshopmanagement.dao.custom;

import lk.ijse.malshanrentshopmanagement.dao.CrudDAO;
import lk.ijse.malshanrentshopmanagement.dto.EliminateEmployeeDto;
import lk.ijse.malshanrentshopmanagement.entity.EliminateEmployee;

public interface EliminateEmployeeDAO extends CrudDAO<EliminateEmployee> {
    boolean saveEliminateEmployee(int id);
}
