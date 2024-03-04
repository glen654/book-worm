package lk.ijse.dao;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory(){

    }

    public static DaoFactory getDaoFactory(){
        return daoFactory == null ? daoFactory = new DaoFactory() : daoFactory;
    }

    public enum DaoTypes{
        ADMIN
    }

    public SuperDao getDao(DaoTypes types){
        switch (types){
            case ADMIN:
                return new AdminDaoImpl();
            default:
                return null;
        }
    }
}
