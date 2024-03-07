package lk.ijse.dto.tm;

public class BranchTm {
    private String bId;
    private String address;
    private int bNumber;
    private String status;
    private String adminId;

    public BranchTm() {
    }

    public BranchTm(String bId, String address, int bNumber, String status, String adminId) {
        this.bId = bId;
        this.address = address;
        this.bNumber = bNumber;
        this.status = status;
        this.adminId = adminId;
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

    public int getbNumber() {
        return bNumber;
    }

    public void setbNumber(int bNumber) {
        this.bNumber = bNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "BranchTm{" +
                "bId='" + bId + '\'' +
                ", address='" + address + '\'' +
                ", bNumber=" + bNumber +
                ", status='" + status + '\'' +
                ", adminId='" + adminId + '\'' +
                '}';
    }
}
