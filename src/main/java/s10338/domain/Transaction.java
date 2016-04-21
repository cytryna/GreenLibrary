package s10338.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private Date dateFrom;
    private Date dateTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    public Transaction() {
    }

    public Transaction(Date dateFrom, Book book, User user, TransactionType transactionType) {
        this.dateFrom = dateFrom;
    }

    public int getId() {
        return id;
    }

    //TODO-rwichrowski Być może usunąć
    public void setId(int id) {
        this.id = id;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date date) {
        this.dateFrom = date;
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

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transaction) {
        this.transactionType = transaction;
    }
}
