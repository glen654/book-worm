package lk.ijse.bo.impl;

import lk.ijse.bo.custom.BookBo;
import lk.ijse.dao.DaoFactory;
import lk.ijse.dao.custom.BookDao;
import lk.ijse.dto.BookDto;
import lk.ijse.entity.Book;

import java.sql.SQLException;

public class BookBoImpl implements BookBo {

    BookDao bookDao = (BookDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.BOOK);
    @Override
    public boolean saveBook(BookDto dto) throws SQLException {
        return bookDao.save(new Book(dto.getbId(), dto.getTitle(), dto.getAuthor(), dto.getGenre(), dto.getStatus()));
    }
}
