package RestApp.controllers.authorControllers;

import RestApp.models.Author;
import RestApp.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class AuthorServiceImpls implements AuthorServiceInterface {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public boolean createAuthor(Author author) {
        if (author == null) { return false; }
        authorRepository.save(author);
        return true;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Set<Book> getAuthorsBooks(int id) {
        Author author = authorRepository.findById(id).get();
        return author.getBooks();
    }

    @Override
    public Author getAuthorById(int id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public boolean deleteAuthorById(int id) {
        authorRepository.deleteById(id);
        return true;
    }
}
