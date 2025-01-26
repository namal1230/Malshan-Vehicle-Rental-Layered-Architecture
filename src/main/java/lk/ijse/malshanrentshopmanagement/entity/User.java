package lk.ijse.malshanrentshopmanagement.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String id;
    private String password;
    private String showPassword;
}
