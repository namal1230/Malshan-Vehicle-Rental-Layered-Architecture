package lk.ijse.malshanrentshopmanagement.dao.custom.impl;

import lk.ijse.malshanrentshopmanagement.dao.SQLUtil;
import lk.ijse.malshanrentshopmanagement.dao.custom.UserDAO;
import lk.ijse.malshanrentshopmanagement.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {
    public boolean checkCredentials(User userDto) {
        try {
            ResultSet resultSet = SQLUtil.execute("SELECT * FROM user WHERE id=? AND password=? OR password=?",userDto.getId(),userDto.getPassword(),userDto.getShowPassword());
            if(resultSet.next()){
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getAllValues(String text) {
        return null;
    }

    @Override
    public ArrayList<User> getAll() {
        return null;
    }

    @Override
    public boolean save(User Dto) {
        return false;
    }

    @Override
    public String generateId() {
        return null;
    }

    @Override
    public ArrayList<User> search(String text) {
        return null;
    }

    @Override
    public boolean searchFromId(String id) {
        return false;
    }

    @Override
    public boolean update(User customerDto) {
        return false;
    }

    @Override
    public boolean delete(int text) {
        return false;
    }
}
