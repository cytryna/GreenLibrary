package s10338.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "authorBook",
            inverseJoinColumns= {@JoinColumn(name = "authorId", referencedColumnName = "id")},
            joinColumns  = {@JoinColumn(name = "bookId", referencedColumnName = "id")})
    private Author author;

    @OneToMany(targetEntity = Transaction.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private List<Transaction> transaction;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public List<Transaction> getTransaction() {
        if (transaction == null || transaction.isEmpty()) {
            transaction = new ArrayList<>();
        }
        return transaction;
    }

        private boolean isAvailable() {
        if (!transaction.isEmpty()) {
//            if (getLastTransaction().getDateTo() == null || getLastTransaction().getDateTo().after(new Date())) {
                return true;
//            }
        }
        return false;
    }

    private Transaction getLastTransaction() {
        return transaction.get(transaction.size()-1);
    }


    public String getReserved() {
        if (isAvailable()) {
            return "Zarezerwowana";
        }
        return "Dostępna";
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        String ret = getTitle();
        if (!getTransaction().isEmpty()) {
            for (Transaction transaction1 : getTransaction()) {
                ret = ret + " " + transaction1.getDateFrom();
            }
        }
        return ret;
    }
}
