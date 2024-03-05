package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBo;
import lk.ijse.dto.AdminDto;
import lk.ijse.dto.BookDto;

import java.sql.SQLException;

public interface BookBo extends SuperBo {
    boolean saveBook(BookDto dto) throws SQLException;
}
