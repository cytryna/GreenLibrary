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

    @Column(name = "title")
    private String title;

    @OneToMany(fetch = FetchType.EAGER)
    private List<BookItem> books;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "author_book",
            joinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")})
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

    public List<BookItem> getBooks() {
        return books;
    }

    public void setBooks(List<BookItem> books) {
        this.books = books;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
