package lk.ijse.bo.impl;

import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.BookBo;
import lk.ijse.bo.custom.BorrowBookBo;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.DaoFactory;
import lk.ijse.dao.custom.BookDao;
import lk.ijse.dao.custom.BranchDao;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.Book;
import lk.ijse.entity.BorrowedBooks;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class BorrowedBookBoImpl implements BorrowBookBo {
    BookBo bookBo = (BookBo) BoFactory.getBOFactory().getBo(BoFactory.BoTypes.BOOK);
    private static final int BORROWING_DAYS = 14;
    @Override
    public boolean placeBorrow(User user, BookDto dto) throws SQLException {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            BookDto bookDto = bookBo.getBookId(dto.getbId());

            Book book =new Book();
            book.setbId(book.getbId());
            book.setStatus(book.getStatus());

            if(bookDto != null && "Available".equals(bookDto.getStatus())){
                dto.setStatus("Unavailable");
                bookBo.updateBook(bookDto);

                BorrowedBooks borrowedBooks = new BorrowedBooks();

                borrowedBooks.setUser(user);
                borrowedBooks.setBook(book);
                borrowedBooks.setBorrowedDate(LocalDateTime.now());

                LocalDateTime returnDate = LocalDateTime.now().plusDays(BORROWING_DAYS);
                borrowedBooks.setReturnDate(returnDate);

                session.save(borrowedBooks);

                transaction.commit();
                return true;
            }else {
                return false;
            }

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }

    }
}