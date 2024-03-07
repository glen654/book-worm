package lk.ijse.dao.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.BranchDao;
import lk.ijse.entity.Book;
import lk.ijse.entity.Branch;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class BranchDaoImpl implements BranchDao {
    @Override
    public boolean save(Branch entity) throws SQLException {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Branch> getAll() {
        return null;
    }

    @Override
    public Book exists(String title) {
        return null;
    }

    @Override
    public boolean update(Branch entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String title) throws SQLException {
        return false;
    }
}
