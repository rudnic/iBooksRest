package RestApp.controllers.bookControllers;

import RestApp.models.Book;

import java.util.List;

public interface BookServiceInterface {

    boolean createBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(int id);

    boolean updateBookById(int id);

    boolean deleteBookById(int id);
}
