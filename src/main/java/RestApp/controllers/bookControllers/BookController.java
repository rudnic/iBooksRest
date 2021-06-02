package RestApp.controllers.bookControllers;

import RestApp.models.Book;
import RestApp.models.BookComment;
import RestApp.models.BookWithListAuthorsIdDTO;
import com.fasterxml.jackson.databind.ser.std.RawSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
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
    public ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(bookServiceInterface.getAllBooks(), HttpStatus.OK);
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
        System.out.println(book.toString());
        bookServiceInterface.createBook(book, bwlaiDTO.getAuthorsId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}/comments/")
    public ResponseEntity<?> addComment(@PathVariable(name = "id") int id, @RequestBody BookComment bookComment) {
        return new ResponseEntity<>(bookServiceInterface.addComment(id, bookComment), HttpStatus.OK);
    }

    @GetMapping("/{id}/comments/")
    public ResponseEntity<?> showComments(@PathVariable(name = "id") int id) {
        return new ResponseEntity<>(bookServiceInterface.showComments(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/")
    public ResponseEntity<?> deleteBook(@PathVariable(name = "id") int id) {
        return new ResponseEntity<>(bookServiceInterface.deleteBookById(id), HttpStatus.OK);
    }

}
