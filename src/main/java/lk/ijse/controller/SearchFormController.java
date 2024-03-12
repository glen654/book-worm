package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.BorrowBookBo;
import lk.ijse.dto.BookDto;
import lk.ijse.entity.Book;
import lk.ijse.entity.User;

import java.sql.SQLException;

public class SearchFormController {
    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblBookId;

    @FXML
    private Label lblBookName;

    @FXML
    private Label lblName;

    @FXML
    private Label lblStatus;

    @FXML
    private Label lblGenre;

    @FXML
    private AnchorPane rootNode;

    BorrowBookBo borrowBookBo = (BorrowBookBo) BoFactory.getBOFactory().getBo(BoFactory.BoTypes.BORROWEDBOOK);

    @FXML
    void btnBorrowOnAction(ActionEvent event) {
        String bookId = lblBookId.getText();
        String bookName = lblBookName.getText();
        String author = lblAuthor.getText();
        String genre = lblGenre.getText();
        String status = lblStatus.getText();

        // Create a BookDto object with the retrieved details
        Book book = new Book(bookId, bookName, author, genre, status);

        // Call the borrowBookBo to borrow the book
        try {
            // Get the currently logged-in user (assuming getCurrentUser is a method that returns the logged-in user)
           User currentUser = getCurrentUser();
            if (currentUser != null) {
                // Borrow the book
                boolean success = borrowBookBo.placeBorrow(currentUser, book);
                if (success) {
                    // Show a success message to the user
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Book borrowed successfully!");
                    alert.show();
                } else {
                    // Show an error message to the user
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Failed to borrow the book.");
                    alert.show();
                }
            } else {
                // Show a warning message to the user indicating they need to log in
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Please log in to borrow a book.");
                alert.show();
            }
        } catch (SQLException e) {
            // Handle any SQL exception that might occur
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("An error occurred while borrowing the book.");
            alert.show();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchBookDetails(BookDto bookDto) {
        lblName.setText(bookDto.getTitle());
        lblBookId.setText(bookDto.getbId());
        lblBookName.setText(bookDto.getTitle());
        lblAuthor.setText(bookDto.getAuthor());
        lblGenre.setText(bookDto.getGenre());
        lblStatus.setText(bookDto.getStatus());
    }
}
