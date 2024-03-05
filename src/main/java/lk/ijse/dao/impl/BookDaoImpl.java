package lk.ijse.dao.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.BookDao;
import lk.ijse.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;

public class BookDaoImpl implements BookDao {
    @Override
    public boolean save(Book entity) throws SQLException {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }
}
