package lk.ijse.bo;

import lk.ijse.dto.AdminDto;

import java.sql.SQLException;

public interface AdminBo extends SuperBo{
    boolean saveAdmin(AdminDto dto) throws SQLException;
}
