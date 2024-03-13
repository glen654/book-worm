package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.BorrowBookBo;
import lk.ijse.bo.custom.UserBo;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.Book;
import lk.ijse.entity.User;

import java.io.IOException;
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

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtUsername;
    private String currentBookId;
    BorrowBookBo borrowBookBo = (BorrowBookBo) BoFactory.getBOFactory().getBo(BoFactory.BoTypes.BORROWEDBOOK);
    UserBo userBo = (UserBo) BoFactory.getBOFactory().getBo(BoFactory.BoTypes.USER);
    private String currenBookName;
    private String currentAuthor;
    private String currentGenre;
    private String currentStatus;

    @FXML
    void btnBorrowOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/confirm_card.fxml"));
        Parent rootNode = loader.load();

        Scene scene = new Scene(rootNode);

        Stage stage = new Stage();
        stage.setTitle("Book Worm");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnConfirmOnAction(ActionEvent event) {
        String bookId = currentBookId;
        String title = currenBookName;
        String author = currentAuthor;
        String genre = currentGenre;
        String status = currentStatus;

        String userName = txtUsername.getText();

        BookDto book = new BookDto(bookId,title,author,genre,status);

        try {
            UserDto userDto = userBo.getUserId(userName);

            User currentUser = convertToUser(userDto);
            if (currentUser != null) {
                boolean success = borrowBookBo.placeBorrow(currentUser, book);
                if (success) {
                    new Alert(Alert.AlertType.CONFIRMATION,"Book borrowed successfull").show();
                } else {
                    new Alert(Alert.AlertType.ERROR,"Book borrow Unsuccessfull").show();
                }
            } else {
                new Alert(Alert.AlertType.ERROR,"Please log into Borrow a Book").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"An Error occurred when borrowing the book").show();
        }
    }

    private User convertToUser(UserDto userDto) {
        if(userDto == null){
            return null;
        }

        User user = new User();
        user.setuId(userDto.getuId());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setConfirmPassword(userDto.getConfirmPassword());

        return user;
    }

    public void searchBookDetails(BookDto bookDto) {
        currentBookId = bookDto.getbId();
        currenBookName = bookDto.getTitle();
        currentAuthor = bookDto.getAuthor();
        currentGenre = bookDto.getGenre();
        currentStatus = bookDto.getStatus();
        lblName.setText(bookDto.getTitle());
        lblBookId.setText(bookDto.getbId());
        lblBookName.setText(bookDto.getTitle());
        lblAuthor.setText(bookDto.getAuthor());
        lblGenre.setText(bookDto.getGenre());
        lblStatus.setText(bookDto.getStatus());
    }
}
