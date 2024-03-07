package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBo;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.BranchDto;

import java.sql.SQLException;

public interface BranchBo extends SuperBo {
    boolean saveBranch(BranchDto dto) throws SQLException;
}
