package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.BorrowBookBo;
import lk.ijse.dto.BorrowedBooksDto;
import lk.ijse.dto.tm.BorrowedBooksTm;
import lk.ijse.entity.Book;

import java.io.IOException;
import java.time.LocalDateTime;

public class BorrowedBooksController {
    @FXML
    private TableColumn<BorrowedBooksDto, Book> colBookId;

    @FXML
    private TableColumn<BorrowedBooksDto, LocalDateTime> colBorrowedDate;

    @FXML
    private TableColumn<BorrowedBooksDto, LocalDateTime> colDueDate;

    @FXML
    private TableColumn<BorrowedBooksDto, String> colId;

    @FXML
    private TableColumn<BorrowedBooksTm, JFXButton> colReturn;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<BorrowedBooksTm> tableBorrowedBooks;

    @FXML
    private Label txtName;

    @FXML
    private AnchorPane rootNode;

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
    void btnBorrowedOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/borrowed_books.fxml"));

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
}
