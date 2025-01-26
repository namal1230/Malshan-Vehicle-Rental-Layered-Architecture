package lk.ijse.malshanrentshopmanagement.dao.custom.impl;

import lk.ijse.malshanrentshopmanagement.dao.SQLUtil;
import lk.ijse.malshanrentshopmanagement.dao.custom.QueryDAO;
import lk.ijse.malshanrentshopmanagement.entity.VehicleSummary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    public ArrayList<VehicleSummary> getAll() {
        try {
            ResultSet rst=SQLUtil.execute("SELECT v.brand,v.model,v.chassie_number,v.color,v.registration_code," +
                    "i.insu_provider,i.insu_policy_number,i.insu_policy_type,vm.maintenance_type " +
                    "FROM vehicle v LEFT JOIN insurance " +
                    "i on v.chassie_number = i.vehicle_chassis " +
                    "LEFT JOIN vehicle_maintenance vm on i.vehicle_chassis = vm.vehicle_chassis");
            ArrayList<VehicleSummary> arrayList= new ArrayList<>();
            if (rst.next()){
                arrayList.add(new VehicleSummary(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),
                        rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8),rst.getString(9)));
            }
            return arrayList;
        }catch (SQLException e){
            System.out.println("Join Query Issue..");
        }
        return null;
    }
}
