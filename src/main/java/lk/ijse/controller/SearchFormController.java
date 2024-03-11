package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dto.BookDto;

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

    @FXML
    void btnBorrowOnAction(ActionEvent event) {

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
