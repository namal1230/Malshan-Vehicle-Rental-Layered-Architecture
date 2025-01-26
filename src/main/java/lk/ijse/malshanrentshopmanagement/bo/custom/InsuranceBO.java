package lk.ijse.malshanrentshopmanagement.bo.custom;

import lk.ijse.malshanrentshopmanagement.bo.SuperBO;
import lk.ijse.malshanrentshopmanagement.dto.InsuranceDto;
import lk.ijse.malshanrentshopmanagement.dto.tm.InsuranceTm;

import java.util.ArrayList;

public interface InsuranceBO extends SuperBO {
    int getInsuranceId();
    boolean delete(String text);
    boolean checkId(String id);
    ArrayList<InsuranceDto> getAll();
    boolean save(InsuranceDto Dto);
    ArrayList<InsuranceDto> search(String text);
    boolean update(InsuranceDto Dto);
}
