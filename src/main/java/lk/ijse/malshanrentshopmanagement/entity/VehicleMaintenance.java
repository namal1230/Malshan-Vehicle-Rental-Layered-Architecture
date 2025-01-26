package lk.ijse.malshanrentshopmanagement.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class VehicleMaintenance {
    private int id;
    private String vehicle_chassis;
    private String maintenance_type;
    private String last_maintenance;
    private String next_maintenance;
    private double repairCost;
}
