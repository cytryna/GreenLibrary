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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_item_id")
    private BookItem bookItem;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private TransactionType transactionType;

    public Transaction() {
    }

    public Transaction(Date dateFrom, BookItem bookItem, User user, TransactionType transactionType) {
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

    public BookItem getBookItem() {
        return bookItem;
    }

    public void setBookItem(BookItem bookItem) {
        this.bookItem = bookItem;
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
