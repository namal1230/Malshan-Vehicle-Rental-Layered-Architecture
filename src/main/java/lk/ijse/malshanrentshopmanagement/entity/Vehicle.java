package lk.ijse.malshanrentshopmanagement.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private String chassie_number;
    private String color;
    private String date;
    private double price;
    private String registration_code;
}
