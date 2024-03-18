package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.UserBo;
import lk.ijse.dto.BorrowedBooksDto;
import lk.ijse.dto.UserDto;
import lk.ijse.dto.tm.BorrowedBooksTm;
import lk.ijse.dto.tm.UserTm;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserFormController implements Initializable {
    @FXML
    private TableColumn<UserTm, JFXButton> colTransaction;

    @FXML
    private TableColumn<UserDto, String> colUserId;

    @FXML
    private TableColumn<UserDto, String> colUserName;

    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TableView<UserTm> tableUser;

    @FXML
    private Label txtName;
    UserBo userBo = (UserBo) BoFactory.getBOFactory().getBo(BoFactory.BoTypes.USER);
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
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/admin_dashboard.fxml"));
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
    void btnUsersOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/user_form.fxml"));

        Scene scene = new Scene(root);

        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableListener();
        loadAllUsers();
        setCellValueFactory();

        colTransaction.setCellFactory(column -> {
            return new TableCell<UserTm, JFXButton>() {
                final JFXButton transButton = new JFXButton("Transaction");

                {
                    transButton.setOnAction(event -> {
                        UserTm user = getTableView().getItems().get(getIndex());
                        openTransactionForm(user);
                    });
                }

                @Override
                protected void updateItem(JFXButton item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty || item == null) {
                        setGraphic(null);
                    } else {
                        setGraphic(transButton);
                        setStyles(transButton);
                    }
                }


            };
        });

    }

    private void setStyles(JFXButton transButton) {
        String buttonStyle = "-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold;";
        buttonStyle += "-fx-cursor: hand;";
        buttonStyle += "-fx-alignment: center;";
        buttonStyle += "-fx-max-width: 120.0;";
        transButton.setStyle(buttonStyle);
    }

    private void openTransactionForm(UserTm user) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/trans_form.fxml"));
            Parent rootNode = loader.load();

            TransactionForm transactionForm = loader.getController();
            transactionForm.setTransData(user);

            Scene scene = new Scene(rootNode);
            Stage stage = new Stage();
            stage.setTitle("Book Worm");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colTransaction.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("Transactions"));
    }

    private void loadAllUsers() {
        ObservableList<UserTm> obList = FXCollections.observableArrayList();

        List<UserDto> dtoList = userBo.getAllUser();

        for(UserDto dto : dtoList){
            JFXButton btnTransactions = new JFXButton("Transactions");

            btnTransactions.setStyle("-fx-background-color: #2980b9; -fx-text-fill: white; -fx-font-weight: bold;");
            btnTransactions.setCursor(Cursor.HAND);
            colTransaction.setStyle("-fx-alignment: CENTER;");
            btnTransactions.setMaxWidth(120.0);

            obList.add(new UserTm(
                    dto.getUserName(),
                    btnTransactions
            ));
        }
        tableUser.setItems(obList);
        tableUser.refresh();
    }

    private void tableListener() {
        tableUser.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            setData(newValue);
        });
    }

    private void setData(UserTm newValue) {
    }
}
