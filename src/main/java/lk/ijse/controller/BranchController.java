package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.AdminBo;
import lk.ijse.bo.custom.BranchBo;
import lk.ijse.dto.AdminDto;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class BranchController implements Initializable {
    @FXML
    private ComboBox<String> cmbAdmin;

    @FXML
    private ComboBox<String> cmbStatus;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colBooks;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colAdminId;

    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TableView<?> tableBranch;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtBookNumber;

    @FXML
    private TextField txtId;

    @FXML
    private Label txtName;
    BranchBo branchBo = (BranchBo) BoFactory.getBOFactory().getBo(BoFactory.BoTypes.BRANCH);
    AdminBo adminBo = (AdminBo) BoFactory.getBOFactory().getBo(BoFactory.BoTypes.ADMIN);
    @FXML
    void btnBooksOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/books_form.fxml"));

        Scene scene = new Scene(root);

        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");
    }

    @FXML
    void btnBranchesOnAction(ActionEvent event) {

    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {

    }

    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/admin_dashboard.fxml"));

        Scene scene = new Scene(root);

        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

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
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnUsersOnAction(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAllAdminId();
    }

    private void loadAllAdminId(){
        ObservableList<String> obList = FXCollections.observableArrayList();

        List<AdminDto> idList = adminBo.getAllAdmin();

        for(AdminDto adminDto : idList){
            obList.add(adminDto.getAdminId());
        }
        cmbAdmin.setItems(obList);
    }

    public boolean validateBranch(){
        String id = txtId.getText();

        boolean isIdValidated = Pattern.matches("[B-][0-9]{3,}", id);
        if (!isIdValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid ID!").show();
            return false;
        }

        String address = txtAddress.getText();

        boolean isAddressValidated = Pattern.matches("[a-z][a-zA-Z\\s]+", address);
        if (!isAddressValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Address!").show();
            return false;
        }

        String noBooks = txtBookNumber.getText();

        boolean isNoBooksValidated = Pattern.matches("[0-9]", noBooks);
        if (!isNoBooksValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Genre!").show();
            return false;
        }

        String status = cmbStatus.getValue();

        boolean isStatusValidated = Pattern.matches("Open|Close", status);
        if (!isStatusValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Status!").show();
            return false;
        }

        String adminId = cmbAdmin.getValue();

        boolean isAdminIdValidated = Pattern.matches("[A-][0-9]{3,}", adminId);
        if (!isAdminIdValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Admin ID!").show();
            return false;
        }

        return true;
    }
}
