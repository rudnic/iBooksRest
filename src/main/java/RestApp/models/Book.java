package RestApp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_books")
    private int id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "annotation")
    private String annotation;

    @Column(name = "category")
    private String category;

//    @Column(name = "average_rating")
//    private Float averageRating;

    @Column(name = "count_likes")
    private Integer countLikes;

    @Column(name = "count_dislikes")
    private Integer countDislikes;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
    private Set<Author> authors;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    private Set<BookComment> bookComments;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

//    public Float getAverageRating() {
//        return averageRating;
//    }
//
//    public void setAverageRating(Float averageRating) {
//        this.averageRating = averageRating;
//    }

    public Integer getCountLikes() {
        return countLikes;
    }

    public void setCountLikes(Integer countLikes) {
        this.countLikes = countLikes;
    }

    public Integer getCountDislikes() {
        return countDislikes;
    }

    public void setCountDislikes(Integer countDislikes) {
        this.countDislikes = countDislikes;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<BookComment> getBookComments() {
        return bookComments;
    }

    public void setBookComments(Set<BookComment> bookComments) {
        this.bookComments = bookComments;
    }
}
