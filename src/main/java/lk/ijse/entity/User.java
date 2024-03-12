package lk.ijse.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(generator = "User-Id-Generator")
    @GenericGenerator(name = "User-Id-Generator", strategy = "lk.ijse.util.UserIdGenerator")
    private String uId;
    private String userName;
    private String password;
    private String confirmPassword;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<BorrowedBooks> borrowedBooks;

    public User() {
    }

    public User(String uId, String userName, String password, String confirmPassword) {
        this.uId = uId;
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
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

    @Override
    public String toString() {
        return "User{" +
                "uId='" + uId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
