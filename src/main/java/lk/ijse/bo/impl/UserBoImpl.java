package lk.ijse.bo.impl;

import lk.ijse.bo.custom.UserBo;
import lk.ijse.dao.DaoFactory;
import lk.ijse.dao.custom.UserDao;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.User;

import java.sql.SQLException;

public class UserBoImpl implements UserBo {
    UserDao userDao = (UserDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.USER);
    @Override
    public boolean saveUser(UserDto dto) throws SQLException {
        return userDao.save(new User(dto.getuId(), dto.getUserName(), dto.getPassword(), dto.getConfirmPassword()));
    }
}
