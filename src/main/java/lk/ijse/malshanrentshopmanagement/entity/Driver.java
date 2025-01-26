package lk.ijse.malshanrentshopmanagement.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Driver {
    private int id;
    private String name;
    private String address;
    private String contact;
    private String email;
    private String dob;
    private String nic;
    private String license_number;
    private String license_exp;
    private String license_type;
    private String medical;
    private String status;

}
