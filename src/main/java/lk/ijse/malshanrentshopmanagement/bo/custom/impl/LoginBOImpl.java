package lk.ijse.malshanrentshopmanagement.bo.custom.impl;

import lk.ijse.malshanrentshopmanagement.bo.custom.LoginBO;
import lk.ijse.malshanrentshopmanagement.dao.DAOFactory;
import lk.ijse.malshanrentshopmanagement.dao.custom.UserDAO;
import lk.ijse.malshanrentshopmanagement.dao.custom.impl.UserDAOImpl;
import lk.ijse.malshanrentshopmanagement.dto.UserDto;
import lk.ijse.malshanrentshopmanagement.entity.User;

public class LoginBOImpl implements LoginBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.GetType.USER);
    @Override
    public boolean checkCredentials(UserDto userDto) {
        return userDAO.checkCredentials(new User(userDto.getId(),userDto.getPassword(),userDto.getShowPassword()));
    }
}
