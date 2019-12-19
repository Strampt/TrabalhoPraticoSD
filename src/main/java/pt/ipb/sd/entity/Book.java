package pt.ipb.sd.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@NamedQueries({@NamedQuery(name = Book.COUNT_ALL, query = "SELECT COUNT(b) FROM Book b"),
        @NamedQuery(name = Book.ALL, query = "SELECT b FROM Book b"),
        @NamedQuery(name = Book.BY_AUTHOR, query = "SELECT b FROM Book b WHERE b.author = :author"),
        @NamedQuery(name = Book.COUNT_BY_AUTHOR, query = "SELECT COUNT(b) FROM Book b WHERE b.author = :author")})

public class Book implements Serializable {
    public final static String ALL = "pt.ipb.sd.jpa.entity.Book.ALL";
    public final static String COUNT_ALL = "pt.ipb.sd.jpa.entity.Book.COUNT_ALL";
    public final static String COUNT_BY_AUTHOR = "pt.ipb.sd.jpa.entity.Book.COUNT_BY_AUTHOR";
    public final static String BY_AUTHOR = "pt.ipb.sd.jpa.entity.Book.BY_AUTHOR";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String title;
    String authors;
    String isbn;
    LocalDate date;

    public Book(String title, String authors, String isbn, LocalDate date) {
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.date = date;
    }

    public Book() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
