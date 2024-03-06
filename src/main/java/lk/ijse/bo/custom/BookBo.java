package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBo;
import lk.ijse.dto.AdminDto;
import lk.ijse.dto.BookDto;

import java.sql.SQLException;
import java.util.List;

public interface BookBo extends SuperBo {
    boolean saveBook(BookDto dto) throws SQLException;

    List<BookDto> getAllBooks();

    BookDto existsBook(String title);

    boolean updateBook(BookDto dto) throws SQLException;
}
