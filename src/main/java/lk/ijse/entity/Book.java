package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(generator = "Book-Id-Generator")
    @GenericGenerator(name = "Book-Id-Generator", strategy = "lk.ijse.util.BookIdGenerator")
    private String bId;
    private String title;
    private String author;
    private String genre;
    private String status;

    public Book() {
    }

    public Book(String bId, String title, String author, String genre, String status) {
        this.bId = bId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.status = status;
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bId='" + bId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
