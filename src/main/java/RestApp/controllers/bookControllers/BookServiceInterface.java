package RestApp.controllers.bookControllers;

import RestApp.models.Book;

import java.util.List;
import java.util.Set;

public interface BookServiceInterface {

    boolean createBook(Book book, List<Integer> authorsId);

    List<Book> getAllBooks();

    Book getBookById(int id);

    boolean updateBookById(int id);

    boolean deleteBookById(int id);
}
