package pt.ipb.sd.ejb;

import pt.ipb.sd.entity.Book;

import javax.ejb.Local;
import java.time.LocalDate;
import java.util.List;

@Local
public interface BookManagerLocal {
    Book create(String title, String author, String isbn, LocalDate date);

    List<Book> getBooks();

    Book update(Book book);

    void delete(Book book);

    void delete(long id);
}
