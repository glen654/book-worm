package lk.ijse.bo.impl;

import lk.ijse.bo.custom.BookBo;
import lk.ijse.dao.DaoFactory;
import lk.ijse.dao.custom.BookDao;
import lk.ijse.dto.BookDto;
import lk.ijse.entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookBoImpl implements BookBo {

    BookDao bookDao = (BookDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.BOOK);
    @Override
    public boolean saveBook(BookDto dto) throws SQLException {
        return bookDao.save(new Book(dto.getbId(), dto.getTitle(), dto.getAuthor(), dto.getGenre(), dto.getStatus()));
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookDao.getAll();
        List<BookDto> bookDtos = new ArrayList<>();
        for(Book book : books){
            bookDtos.add(new BookDto(book.getbId(),book.getTitle(),book.getAuthor(),book.getGenre(),book.getStatus()));
        }
        return bookDtos;
    }

    @Override
    public BookDto existsBook(String title) {
        Book book = bookDao.exists(title);
        BookDto bookDto = new BookDto(book.getAuthor(), book.getGenre(), book.getStatus());
        return bookDto;
    }
}
