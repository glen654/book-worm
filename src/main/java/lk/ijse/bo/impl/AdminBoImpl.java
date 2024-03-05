package lk.ijse.bo.impl;

import lk.ijse.bo.custom.AdminBo;
import lk.ijse.dao.custom.AdminDao;
import lk.ijse.dao.DaoFactory;
import lk.ijse.dto.AdminDto;
import lk.ijse.entity.Admin;

import java.sql.SQLException;

public class AdminBoImpl implements AdminBo {

    AdminDao adminDao = (AdminDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ADMIN);
    @Override
    public boolean saveAdmin(AdminDto dto) throws SQLException {
        return adminDao.save(new Admin(dto.getAdminId(), dto.getUserName(), dto.getPassword(), dto.getConfirmPassword()));
    }

    @Override
    public AdminDto adminSignIn(String username, String password) {
        Admin admin = adminDao.signIn(username, password);
        if(admin != null){
            AdminDto adminDto = new AdminDto(admin.getUserName(),admin.getPassword());
            return adminDto;
        }else {
            return null;
        }
    }

}
