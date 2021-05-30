package RestApp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "AUTHORS")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idauthors")
    private int id;

    @Column(name = "authorFirstname")
    private String firstname;

    @Column(name = "authorMiddlename")
    private String middlename;

    @Column(name = "authorLastname")
    private String lastname;

    @ManyToMany
    @JoinTable(name = "AUTHORS_BOOKS",
            joinColumns = @JoinColumn(name = "authorId", referencedColumnName = "idauthors"),
            inverseJoinColumns = @JoinColumn(name = "bookId", referencedColumnName = "idbooks")
    )
    @JsonIgnoreProperties(value = { "books" ,"hibernateLazyInitializer", "handler" }, allowSetters = true)
    @JsonBackReference
    private Set<Book> books;

    public Author() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
