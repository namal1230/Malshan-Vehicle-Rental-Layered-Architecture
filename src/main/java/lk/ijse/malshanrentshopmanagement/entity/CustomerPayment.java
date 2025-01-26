package lk.ijse.malshanrentshopmanagement.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CustomerPayment {
    private int customerId;
    private String method;
    private String cardNumber;
    private int vehicleId;
    private String rentalPeriod;
    private String locationDistance;
    private int driverId;
}
