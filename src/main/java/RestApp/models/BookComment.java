package RestApp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "BOOK_COMMENTS")
public class BookComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnoreProperties(value = { "book" ,"hibernateLazyInitializer", "handler" }, allowSetters = true)
    @JsonBackReference
    private Book book;

    @Column(name = "comment_text")
    private String commentText;

     @ManyToOne
     @JoinColumn(name = "user_id")
     private User user;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
