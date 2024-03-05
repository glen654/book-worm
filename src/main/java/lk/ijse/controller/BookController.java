package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class BookController {
    @FXML
    private ComboBox<?> cmbGenre;

    @FXML
    private ComboBox<?> cmbStatus;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colGenre;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<?> tableBooks;

    @FXML
    private TextField txtAuthor;

    @FXML
    private Label txtName;

    @FXML
    private TextField txtTitle;

    @FXML
    void btnBooksOnAction(ActionEvent event) {

    }

    @FXML
    void btnBranchesOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnSignOutOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnUsersOnAction(ActionEvent event) {

    }
}
