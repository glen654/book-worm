package lk.ijse.bo.impl;

import lk.ijse.bo.custom.BorrowBookBo;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Book;
import lk.ijse.entity.BorrowedBooks;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class BorrowedBookBoImpl implements BorrowBookBo {
    private static final int BORROWING_DAYS = 14;
    @Override
    public boolean placeBorrow(User user, Book book) throws SQLException {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            book.setStatus("Unavailable");

            BorrowedBooks borrowedBooks = new BorrowedBooks();

            borrowedBooks.setUser(user);
            borrowedBooks.setBook(book);
            borrowedBooks.setBorrowedDate(LocalDateTime.now());

            LocalDateTime returnDate = LocalDateTime.now().plusDays(BORROWING_DAYS);
            borrowedBooks.setReturnDate(returnDate);

            session.save(borrowedBooks);

            transaction.commit();
            return true;
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
