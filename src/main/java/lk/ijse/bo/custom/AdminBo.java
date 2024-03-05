package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBo;
import lk.ijse.dto.AdminDto;

import java.sql.SQLException;

public interface AdminBo extends SuperBo {
    boolean saveAdmin(AdminDto dto) throws SQLException;
    AdminDto adminSignIn(String username, String password);

}
