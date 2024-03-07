package lk.ijse.bo;

import lk.ijse.bo.impl.AdminBoImpl;
import lk.ijse.bo.impl.BookBoImpl;
import lk.ijse.bo.impl.BranchBoImpl;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory(){

    }

    public static BoFactory getBOFactory(){
        return boFactory == null ? boFactory = new BoFactory() : boFactory;
    }

    public enum BoTypes{
        ADMIN,BOOK,BRANCH
    }

    public SuperBo getBo(BoTypes types){
        switch (types){
            case ADMIN:
                return new AdminBoImpl();
            case BOOK:
                return new BookBoImpl();
            case BRANCH:
                return new BranchBoImpl();
            default:
                return null;
        }
    }
}
