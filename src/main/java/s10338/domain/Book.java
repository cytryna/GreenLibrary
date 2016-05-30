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

//    public String getAuthorsString() {
//        if (authors.isEmpty()) {
//            return "";
//        }
//        StringBuilder authorsString = new StringBuilder();
//        authors.forEach(author -> authorsString.append(author.getName() + ", "));
//        authorsString.delete(authorsString.lastIndexOf(", "), authorsString.length());
//        return authorsString.toString();
//    }

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

    //TODO-rwichrowski zminić na dostępną książkę
    private boolean isReserved() {
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
        if (isReserved()) {
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
