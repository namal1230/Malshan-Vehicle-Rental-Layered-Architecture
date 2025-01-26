package lk.ijse.malshanrentshopmanagement.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Insurance {
    private int id;
    private String insu_provider;
    private String vehicle_chassis;
    private String insu_policy_number;
    private String insu_policy_type;
    private String startDate;
    private String expiryDate;
}
