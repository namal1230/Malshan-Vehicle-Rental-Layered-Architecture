package lk.ijse.malshanrentshopmanagement.bo.custom.impl;

import lk.ijse.malshanrentshopmanagement.bo.custom.InsuranceBO;
import lk.ijse.malshanrentshopmanagement.dao.DAOFactory;
import lk.ijse.malshanrentshopmanagement.dao.custom.InsuranceDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.InsuranceDAOImpl;
import lk.ijse.malshanrentshopmanagement.dto.InsuranceDto;
import lk.ijse.malshanrentshopmanagement.entity.Insurance;

import java.util.ArrayList;

public class InsuranceBOImpl implements InsuranceBO {

    InsuranceDAO insuranceDAO = (InsuranceDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.INSURANCE);
    @Override
    public int getInsuranceId() {
        return insuranceDAO.getInsuranceId();
    }

    @Override
    public boolean delete(String text) {
        return insuranceDAO.delete(text);
    }

    @Override
    public boolean checkId(String id) {
        return insuranceDAO.checkId(id);
    }

    @Override
    public ArrayList<InsuranceDto> getAll() {
        ArrayList<Insurance> all = insuranceDAO.getAll();
        ArrayList<InsuranceDto> insuranceDtos = new ArrayList<>();
        for (Insurance insurance:all){
            insuranceDtos.add(new InsuranceDto(insurance.getId(),insurance.getInsu_provider(),
                    insurance.getVehicle_chassis(),insurance.getInsu_policy_number(),
                    insurance.getInsu_policy_type(),insurance.getStartDate(),insurance.getExpiryDate()));
        }
        return insuranceDtos;
    }

    @Override
    public boolean save(InsuranceDto Dto) {
        return insuranceDAO.save(new Insurance(Dto.getId(),Dto.getInsu_provider(),
                Dto.getVehicle_chassis(),Dto.getInsu_policy_number(),
                Dto.getInsu_policy_type(),Dto.getStartDate(),Dto.getExpiryDate()));
    }

    @Override
    public ArrayList<InsuranceDto> search(String text) {
        ArrayList<Insurance> search = insuranceDAO.search(text);
        ArrayList<InsuranceDto> insuranceDtos = new ArrayList<>();
        for (Insurance insurance:search){
            insuranceDtos.add(new InsuranceDto(insurance.getId(),insurance.getInsu_provider(),
                    insurance.getVehicle_chassis(),insurance.getInsu_policy_number(),
                    insurance.getInsu_policy_type(),insurance.getStartDate(),insurance.getExpiryDate()));
        }
        return insuranceDtos;
    }

    @Override
    public boolean update(InsuranceDto Dto) {
        return insuranceDAO.update(new Insurance(Dto.getId(),Dto.getInsu_provider(),
                Dto.getVehicle_chassis(),Dto.getInsu_policy_number(),
                Dto.getInsu_policy_type(),Dto.getStartDate(),Dto.getExpiryDate()));
    }

}
