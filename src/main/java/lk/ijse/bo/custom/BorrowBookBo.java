package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBo;
import lk.ijse.entity.Book;
import lk.ijse.entity.User;

import java.sql.SQLException;

public interface BorrowBookBo extends SuperBo {
    boolean placeBorrow(User user, Book book) throws SQLException;
}
