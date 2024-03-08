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
import lk.ijse.bo.custom.BookBo;
import lk.ijse.bo.custom.BranchBo;
import lk.ijse.dao.DaoFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainAdminController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private Label txtBookCount;

    @FXML
    private Label txtBranchCount;

    @FXML
    private Label txtName;

    @FXML
    private Label txtUserCount;
    BranchBo branchBo = (BranchBo) BoFactory.getBOFactory().getBo(BoFactory.BoTypes.BRANCH);
    BookBo bookBo = (BookBo) BoFactory.getBOFactory().getBo(BoFactory.BoTypes.BOOK);
    @FXML
    void btnBooksOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/books_form.fxml"));

        Scene scene = new Scene(root);

        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");
    }

    @FXML
    void btnBranchesOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/branch_form.fxml"));

        Scene scene = new Scene(root);

        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");
    }

    @FXML
    void btnSignOutOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/admin_login.fxml"));

        Scene scene = new Scene(rootNode);

        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");
    }

    @FXML
    void btnUsersOnAction(ActionEvent event) {

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTxtBranchCount(txtBranchCount);
        setTxtBookCount(txtBookCount);
    }

    public void setTxtBranchCount(Label txtBranchCount) {
        String branchCount = String.valueOf(0);
        try {
            branchCount = branchBo.getBranchCount();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        txtBranchCount.setText(branchCount);
    }

    public void setTxtBookCount(Label txtBookCount){
        String bookCount = String.valueOf(0);

        try {
            bookCount = bookBo.getBookCount();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        txtBookCount.setText(bookCount);
    }
}
