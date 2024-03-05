package lk.ijse.dao.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.AdminDao;
import lk.ijse.entity.Admin;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    @Override
    public boolean save(Admin entity) throws SQLException {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Admin signIn(String username, String password) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("select a from admin a where userName = ?1 and password = ?2");
            query.setParameter(1,username);
            query.setParameter(2,password);
            return (Admin) query.getSingleResult();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return null;
    }

}