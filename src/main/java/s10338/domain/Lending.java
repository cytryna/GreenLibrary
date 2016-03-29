package s10338.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "lending")
public class Lending {

    @Id
    @GeneratedValue
    private long id;

    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private Transaction transaction;

    public Lending() {
    }

    public Lending(Date date, Book book, User user, Transaction transaction) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    //TODO-rwichrowski Być może usunąć
    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
