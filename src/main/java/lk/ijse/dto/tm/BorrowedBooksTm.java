package lk.ijse.dto.tm;

import java.time.LocalDateTime;

public class BorrowedBooksTm {
    private String bId;
    private LocalDateTime borrowedDate;
    private LocalDateTime returnDate;
    private String bookId;
    private String uId;

    public BorrowedBooksTm() {
    }

    public BorrowedBooksTm(String bId, LocalDateTime borrowedDate, LocalDateTime returnDate, String bookId, String uId) {
        this.bId = bId;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.bookId = bookId;
        this.uId = uId;
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public LocalDateTime getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDateTime borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    @Override
    public String toString() {
        return "BorrowedBooksTm{" +
                "bId='" + bId + '\'' +
                ", borrowedDate=" + borrowedDate +
                ", returnDate=" + returnDate +
                ", bookId='" + bookId + '\'' +
                ", uId='" + uId + '\'' +
                '}';
    }
}
