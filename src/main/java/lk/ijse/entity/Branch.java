package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity(name = "branches")
public class Branch {
    @Id
    private String bId;
    private String address;
    private String bNumber;
    private String status;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public Branch() {
    }

    public Branch(String bId, String address, String bNumber, String status, Admin admin) {
        this.bId = bId;
        this.address = address;
        this.bNumber = bNumber;
        this.status = status;
        this.admin = admin;
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getbNumber() {
        return bNumber;
    }

    public void setbNumber(String bNumber) {
        this.bNumber = bNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "bId='" + bId + '\'' +
                ", address='" + address + '\'' +
                ", bNumber='" + bNumber + '\'' +
                ", status='" + status + '\'' +
                ", admin=" + admin +
                '}';
    }
}
