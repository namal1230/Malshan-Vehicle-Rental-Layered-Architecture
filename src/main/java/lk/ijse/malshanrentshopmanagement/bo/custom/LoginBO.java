package lk.ijse.malshanrentshopmanagement.bo.custom;

import lk.ijse.malshanrentshopmanagement.bo.SuperBO;
import lk.ijse.malshanrentshopmanagement.dto.UserDto;

public interface LoginBO extends SuperBO {
    boolean checkCredentials(UserDto userDto);
}
