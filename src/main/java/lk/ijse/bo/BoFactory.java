package lk.ijse.bo;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory(){

    }

    public static BoFactory getBOFactory(){
        return boFactory == null ? boFactory = new BoFactory() : boFactory;
    }

    public enum BoTypes{
        ADMIN
    }

    public SuperBo getBo(BoTypes types){
        switch (types){
            case ADMIN:
                return new AdminBoImpl();
            default:
                return null;
        }
    }
}
