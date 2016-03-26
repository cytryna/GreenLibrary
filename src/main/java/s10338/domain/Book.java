package s10338.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

//    @Column(name = "isbn", nullable = false, length = 13)
//    private String isbn;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="author_book",
            joinColumns={@JoinColumn(name="author_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="book_id", referencedColumnName="id")})
    private List<Author> authors = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public String getAuthorsString() {
        if (authors.isEmpty()) {
            return "";
        }
        StringBuilder authorsString = new StringBuilder();
        authors.forEach(author -> authorsString.append(author.getName() + ", "));
        authorsString.delete(authorsString.lastIndexOf(", "), authorsString.length());
        return authorsString.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getIsbn() {
//        return isbn;
//    }
//
//    public void setIsbn(String isbn) {
//        this.isbn = isbn;
//    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
