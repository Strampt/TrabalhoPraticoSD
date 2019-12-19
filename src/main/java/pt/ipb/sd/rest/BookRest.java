package pt.ipb.sd.rest;

import pt.ipb.sd.ejb.BookManagerRemote;
import pt.ipb.sd.entity.Book;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/books")
public class BookRest {
    @EJB
    BookManagerRemote bookManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> list() {
        return bookManager.getBooks();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String create(Book book) {
        Client client = ClientBuilder.newClient();
        Book newBook = bookManager.create(book.getTitle(), book.getAuthors(), book.getIsbn(), book.getDate());
        WebTarget target = client.target("http://localhost/api/books");
        String response = target.request(MediaType.APPLICATION_JSON)
                .accept(MediaType.TEXT_PLAIN_TYPE)
                .post(Entity.json(newBook), String.class);
        return response;
    }

    @DELETE
    @Path("{id}")
    public void deleteBookById(@PathParam("id") long id) {
        bookManager.delete(id);
    }
}
