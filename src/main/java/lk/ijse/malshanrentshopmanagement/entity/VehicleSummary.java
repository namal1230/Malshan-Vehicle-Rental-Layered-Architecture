package lk.ijse.malshanrentshopmanagement.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class VehicleSummary {
    private String brand;
    private String model;
    private String chassie_number;
    private String color;
    private String register_code;
    private String provider;
    private String policynumber;
    private String policyType;
    private String MaintenanceType;
}
