package pt.ipb.sd.jsf;

import pt.ipb.sd.ejb.BookManagerRemote;
import pt.ipb.sd.entity.Book;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.List;

@Named
@RequestScoped
public class BooksBackingBean {

    @EJB
    BookManagerRemote bookManager;
    String isbn;
    String authors;
    String title;

    public List<Book> getBooks() {
        return bookManager.getBooks();
    }

    public String getName() {
        return "testing... one, two, three... testing";
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String doCreateBook() {
        this.bookManager.create(getTitle(), getAuthors(), getIsbn(), LocalDate.now());
        return "books";
    }

}
