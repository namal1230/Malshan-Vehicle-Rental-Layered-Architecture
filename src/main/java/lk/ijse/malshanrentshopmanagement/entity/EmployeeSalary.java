package lk.ijse.malshanrentshopmanagement.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class EmployeeSalary {
    private int id;
    private String salary;
    private String bank_account;
    private String tax;
    private String probation_period;
    private String date;
}
