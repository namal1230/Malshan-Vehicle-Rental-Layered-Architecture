package lk.ijse.malshanrentshopmanagement.dao.custom;

import lk.ijse.malshanrentshopmanagement.dao.CrudDAO;
import lk.ijse.malshanrentshopmanagement.dto.UserDto;
import lk.ijse.malshanrentshopmanagement.entity.User;

public interface UserDAO extends CrudDAO<User> {
    boolean checkCredentials(User user);
}
