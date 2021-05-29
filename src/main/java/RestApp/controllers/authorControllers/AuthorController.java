package RestApp.controllers.authorControllers;

import RestApp.models.Author;
import RestApp.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

    private AuthorServiceInterface authorServiceInterface;
    @Autowired
    public AuthorController(AuthorServiceInterface authorServiceInterface) {
        this.authorServiceInterface = authorServiceInterface;
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> getALlAuthors() {
        return new ResponseEntity<>(authorServiceInterface.getAllAuthors(), HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> createAuthor(@RequestBody Author author) {
        return new ResponseEntity<>(authorServiceInterface.createAuthor(author), HttpStatus.OK);
    }

    @GetMapping("/{id}/")
    public ResponseEntity<?> getAuthorByID(@PathVariable(name = "id") int id) {
        final Author author = authorServiceInterface.getAuthorById(id);
        return author != null
                ? new ResponseEntity<>(author, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/books/")
    public Set<Book> getAuthorsBooks(@PathVariable(name = "id") int id) {
        return authorServiceInterface.getAuthorsBooks(id);
    }

    @DeleteMapping(value = "/{id}/")
    public boolean deleteAuthorById(@PathVariable(name = "id") int id) {
        return authorServiceInterface.deleteAuthorById(id);
    }
}
