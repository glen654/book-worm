package lk.ijse.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.BorrowBookBo;
import lk.ijse.dto.BorrowedBooksDto;
import lk.ijse.dto.tm.UserTm;

import java.util.List;

public class TransactionForm {
    @FXML
    private Label lblBookId;

    @FXML
    private Label lblBorrowDate;

    @FXML
    private Label lblDueDate;

    @FXML
    private AnchorPane rootNode;
    BorrowBookBo borrowBookBo = (BorrowBookBo) BoFactory.getBOFactory().getBo(BoFactory.BoTypes.BORROWEDBOOK);
    public void setTransData(UserTm user) {
        List<BorrowedBooksDto> borrowedBooksList = borrowBookBo.getBorrowedBooksByUserId(user.getuId());

        if (!borrowedBooksList.isEmpty()) {
            BorrowedBooksDto borrowedBooksDto = borrowedBooksList.get(0);
            lblBorrowDate.setText(String.valueOf(borrowedBooksDto.getBorrowedDate()));
            lblDueDate.setText(String.valueOf(borrowedBooksDto.getReturnDate()));
            lblBookId.setText(String.valueOf(borrowedBooksDto.getBookId()));
        } else {
            System.out.println("No borrowed books found for the user.");
        }
    }
}
