package lk.ijse.malshanrentshopmanagement.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    private int id;
    private String name;
    private String address;
    private String contact;
    private String nic;
    private String dob;
    private String email;
    private int driverId;
    private String licen_number;
    private int vehicleId;
    private String date;
}
