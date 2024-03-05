package lk.ijse.dao;

import lk.ijse.dao.impl.AdminDaoImpl;
import lk.ijse.dao.impl.BookDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory(){

    }

    public static DaoFactory getDaoFactory(){
        return daoFactory == null ? daoFactory = new DaoFactory() : daoFactory;
    }

    public enum DaoTypes{
        ADMIN,BOOK
    }

    public SuperDao getDao(DaoTypes types){
        switch (types){
            case ADMIN:
                return new AdminDaoImpl();
            case BOOK:
                return new BookDaoImpl();
            default:
                return null;
        }
    }
}
