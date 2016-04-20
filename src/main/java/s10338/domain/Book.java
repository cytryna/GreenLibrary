package s10338.domain;

import javax.persistence.*;
import java.util.*;

//ogólnie
@Entity
@Table(name = "book")
public class Book {

//    private static Map<String, Book> books = new HashMap<>();
//TODO-rwichrowski dodać isbn
    @Id
    @GeneratedValue
    private int id;

    private String title;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "authorBook",
            joinColumns = {@JoinColumn(name = "authorId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "bookId", referencedColumnName = "id")})
    private List<Author> authors = new ArrayList<>();

    public Book() {
    }

    public Book(String title) {
//        books.put(title, new Book(title));
        this.title = title;
    }

//TODO-rwichrowski Jak zaimplementować cash
//    public static Book create(String title) {
//        if (books.containsKey(title)) {
//            return books.get(title);
//        }
//        Book book = new Book(title);
//        books.put(title, book);
//        return book;
//    }

    public String getAuthorsString() {
        if (authors.isEmpty()) {
            return "";
        }
        StringBuilder authorsString = new StringBuilder();
        authors.forEach(author -> authorsString.append(author.getName() + ", "));
        authorsString.delete(authorsString.lastIndexOf(", "), authorsString.length());
        return authorsString.toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getId() {
        return id;
    }
}
