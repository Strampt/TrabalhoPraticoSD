package pt.ipb.sd.ejb;


import pt.ipb.sd.entity.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class BookManager implements BookManagerLocal, BookManagerRemote {

    @PersistenceContext(unitName = "meteo-pu")
    EntityManager entityManager;


    @Override
    public Book create(String title, String author, String isbn, LocalDate date) {
        Book book = new Book(title, author, isbn, date);
        entityManager.persist(book);
        return book;
    }

    @Override
    public List<Book> getBooks() {
        List<Book> l = entityManager.createNamedQuery(Book.ALL, Book.class)
                .getResultList();
        return l;
    }

    @Override
    public Book update(Book book) {
        return entityManager.merge(book);
    }

    @Override
    public void delete(Book book) {
        entityManager.remove(book);
    }

    @Override
    public void delete(long id) {
        Book book = entityManager.find(Book.class, id);
        entityManager.remove(book);
    }
}
