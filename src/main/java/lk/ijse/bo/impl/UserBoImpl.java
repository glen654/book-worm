package lk.ijse.bo.impl;

import lk.ijse.bo.custom.UserBo;
import lk.ijse.dao.DaoFactory;
import lk.ijse.dao.custom.UserDao;
import lk.ijse.dto.AdminDto;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.Admin;
import lk.ijse.entity.Book;
import lk.ijse.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBoImpl implements UserBo {
    UserDao userDao = (UserDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.USER);
    @Override
    public boolean saveUser(UserDto dto) throws SQLException {
        return userDao.save(new User(dto.getuId(), dto.getUserName(), dto.getPassword(), dto.getConfirmPassword()));
    }

    @Override
    public UserDto userSignIn(String username, String password) {
        User user = userDao.signIn(username, password);
        if(user != null){
            UserDto userDto = new UserDto(user.getUserName(),user.getPassword());
            return userDto;
        }else {
            return null;
        }
    }

    @Override
    public boolean updateUser(UserDto dto) throws SQLException {
        return userDao.update(new User(dto.getuId(), dto.getUserName(), dto.getPassword(), dto.getConfirmPassword()));
    }

    @Override
    public UserDto getUserId(String username) throws SQLException {
        String user = userDao.get(username);
        if(user != null){
            UserDto userDto = new UserDto(user);
            return userDto;
        }else {
            return null;
        }
    }

    @Override
    public String getUserCount() throws SQLException {
        return userDao.getCount();
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userDao.getAll();
        List<UserDto> userDtos = new ArrayList<>();
        for(User user : users){
            userDtos.add(new UserDto(user.getuId(),user.getUserName(),user.getPassword(),user.getConfirmPassword()));
        }
        return userDtos;
    }
}
