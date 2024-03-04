package lk.ijse.dao;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Admin;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao{
    @Override
    public boolean save(Admin entity) throws SQLException {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }
}
