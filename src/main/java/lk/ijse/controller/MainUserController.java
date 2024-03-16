package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.BorrowBookBo;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainUserController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private Label txtBorrowedBooks;

    @FXML
    private Label txtDueBooks;

    @FXML
    private Label txtName;

    BorrowBookBo borrowBookBo = (BorrowBookBo) BoFactory.getBOFactory().getBo(BoFactory.BoTypes.BORROWEDBOOK);

    @FXML
    void btnBooksOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/user_book.fxml"));

        Scene scene = new Scene(root);

        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/user_dashboard.fxml"));

        Scene scene = new Scene(root);

        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");
    }

    @FXML
    void btnPasswordOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/change_password.fxml"));

        Scene scene = new Scene(root);

        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");
    }

    @FXML
    void btnSignOutOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/user_login.fxml"));

        Scene scene = new Scene(rootNode);

        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");
    }


    @FXML
    void btnBorrowedOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/borrowed_books.fxml"));

        Scene scene = new Scene(root);

        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");
    }

    public void setUserName(String userName) {
        this.txtName.setText(userName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTxtBorrowedBooks(txtBorrowedBooks);
        setTxtDueBooks(txtDueBooks);
    }

    private void setTxtDueBooks(Label txtDueBooks) {
        String borrowCount = String.valueOf(0);

        try {
            borrowCount = borrowBookBo.getBorrowedCount();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        txtBorrowedBooks.setText(borrowCount);
    }

    private void setTxtBorrowedBooks(Label txtBorrowedBooks) {
        String dueCount = String.valueOf(0);

        try {
            dueCount = borrowBookBo.getBorrowedCount();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        txtDueBooks.setText(dueCount);
    }
}
