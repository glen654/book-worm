package lk.ijse.bo;

import lk.ijse.dao.AdminDao;
import lk.ijse.dao.DaoFactory;
import lk.ijse.dto.AdminDto;
import lk.ijse.entity.Admin;

import java.sql.SQLException;

public class AdminBoImpl implements AdminBo{

    AdminDao adminDao = (AdminDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ADMIN);
    @Override
    public boolean saveAdmin(AdminDto dto) throws SQLException {
        return adminDao.save(new Admin(dto.getUserName(), dto.getPassword(), dto.getConfirmPassword()));
    }
}
