package RestApp.controllers.authorControllers;

import RestApp.models.Author;
import RestApp.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Author> getALlAuthors() {
        return authorServiceInterface.getAllAuthors();
    }

    @GetMapping("/{id}/")
    public ResponseEntity<Author> getAuthorByID(@PathVariable(name = "id") int id) {
        final Author author = authorServiceInterface.getAuthorById(id);
        return author != null
                ? new ResponseEntity<>(author, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/books/")
    public Set<Book> getAuthorsBooks(@PathVariable(name = "id") int id) {
        return authorServiceInterface.getAuthorsBooks(id);
    }
}
