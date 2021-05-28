package RestApp.controllers.authorControllers;

import RestApp.models.Author;
import RestApp.models.Book;

import java.util.List;
import java.util.Set;

public interface AuthorServiceInterface {

    boolean createAuthor(Author author);

    List<Author> getAllAuthors();

    Set<Book> getAuthorsBooks(int id);

    Author getAuthorById(int id);

    boolean updateAuthorById(int id);

    boolean deleteAuthorById(int id);
}
