package RestApp.controllers.bookControllers;

import RestApp.controllers.authorControllers.AuthorRepository;
import RestApp.controllers.commentsController.CommentsRepository;
import RestApp.models.Author;
import RestApp.models.Book;
import RestApp.models.BookComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class BookServiceImpl implements BookServiceInterface {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CommentsRepository commentsRepository;


    @Override
    public boolean createBook(Book book, List<Integer> authorsId) {
        Set<Author> authors = new HashSet<>(authorRepository.findAllById(authorsId));
        book.setAuthors(authors);
        bookRepository.save(book);

        for (Author author : authors) {
            Set<Book> authorBooks = author.getBooks();
            authorBooks.add(book);
            author.setBooks(authorBooks);
            authorRepository.save(author);
        }
        return true;
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

    @Override
    public boolean addComment(int id, BookComment bookComment) {
        bookComment.setBook(bookRepository.findById(id).get());
        commentsRepository.save(bookComment);
        Book book = bookRepository.findById(id).get();
        Set<BookComment> comments = book.getBookComments();
        comments.add(bookComment);
        book.setBookComments(comments);
        bookRepository.save(book);
        return true;
    }

    @Override
    public Set<BookComment> showComments(int id) {
        return bookRepository.findById(id).get().getBookComments();
    }
}
