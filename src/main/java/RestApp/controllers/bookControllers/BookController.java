package RestApp.controllers.bookControllers;

import RestApp.models.Book;
import RestApp.models.BookWithListAuthorsIdDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    private final BookServiceInterface bookServiceInterface;

    @Autowired
    public BookController(BookServiceInterface bookServiceInterface) {
        this.bookServiceInterface = bookServiceInterface;
    }

    @GetMapping("/")
    public List<Book> getAllBooks() {
        return bookServiceInterface.getAllBooks();
    }

    @GetMapping("/{id}/")
    public ResponseEntity<Book> getBookByID(@PathVariable(name = "id") int id) {
        final Book book = bookServiceInterface.getBookById(id);
        return book != null
                ? new ResponseEntity<>(book, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<?> createBook(@RequestBody BookWithListAuthorsIdDTO bwlaiDTO) {
        Book book = new Book();
        book.setName(bwlaiDTO.getName());
        book.setCategory(bwlaiDTO.getCategory());
        book.setAnnotation(bwlaiDTO.getAnnotation());
        book.setAverageRating(bwlaiDTO.getAverageRating());
        bookServiceInterface.createBook(book, bwlaiDTO.getAuthorsId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
