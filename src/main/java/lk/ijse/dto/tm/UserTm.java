package lk.ijse.dto.tm;

import com.jfoenix.controls.JFXButton;

public class UserTm {
    private String uId;
    private String userName;
    private String password;
    private String confirmPassword;

    private JFXButton Transactions;

    public UserTm() {
    }

    public UserTm(String uId, String userName, String password, String confirmPassword, JFXButton transactions) {
        this.uId = uId;
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        Transactions = transactions;
    }


    public UserTm(String userName, JFXButton btnTransactions) {
        this.userName = userName;
        this.Transactions = btnTransactions;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public JFXButton getTransactions() {
        return Transactions;
    }

    public void setTransactions(JFXButton transactions) {
        Transactions = transactions;
    }

    @Override
    public String toString() {
        return "UserTm{" +
                "uId='" + uId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", Transactions=" + Transactions +
                '}';
    }
}
