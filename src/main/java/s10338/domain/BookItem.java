package s10338.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//konkretna książka z wydartą kartką
@Entity
@Table(name = "book_item")
public class BookItem {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Book book;

//    @ManyToOne(fetch = FetchType.EAGER)
//    private Transaction transaction;

    public BookItem() {
    }

//    public BookItem(String title) {
//        book = new Book(title);
//    }

    public BookItem(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return book.getTitle();
    }

    public List<Author> getAuthors() {
        return book.getAuthors();
    }
}
