package lk.ijse.dao;

import lk.ijse.dao.impl.AdminDaoImpl;
import lk.ijse.dao.impl.BookDaoImpl;
import lk.ijse.dao.impl.BranchDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory(){

    }

    public static DaoFactory getDaoFactory(){
        return daoFactory == null ? daoFactory = new DaoFactory() : daoFactory;
    }

    public enum DaoTypes{
        ADMIN,BOOK,BRANCH
    }

    public SuperDao getDao(DaoTypes types){
        switch (types){
            case ADMIN:
                return new AdminDaoImpl();
            case BOOK:
                return new BookDaoImpl();
            case BRANCH:
                return new BranchDaoImpl();
            default:
                return null;
        }
    }
}
