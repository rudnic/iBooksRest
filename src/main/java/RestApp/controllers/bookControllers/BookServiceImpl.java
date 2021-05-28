package RestApp.controllers.bookControllers;

import RestApp.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookServiceInterface {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public boolean createBook(Book book) {
        return false;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public boolean updateBookById(int id) {
        return false;
    }

    @Override
    public boolean deleteBookById(int id) {
        return false;
    }
}
