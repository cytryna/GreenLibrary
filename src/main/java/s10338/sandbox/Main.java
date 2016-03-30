package s10338.sandbox;

import s10338.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private List<Author> authors;

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        try {
            authors = new ArrayList<>();
            authors.add(new Author("Adam"));
            authors.add(new Author("Jan"));
            authors.add(new Author("Marcin"));
            authors.add(new Author("Robert"));
            authors.add(new Author("Anna"));
            authors.add(new Author("Leopold"));

            List<BookItem> bookItems = new ArrayList<>();
            bookItems.add(createBook("Antygona"));
            bookItems.add(createBook("Bogurodzica"));
            bookItems.add(createBook("Lalka"));
            bookItems.add(createBook("Wesele"));
            bookItems.add(createBook("W pustyni i w puszczy"));
            bookItems.add(createBook("Pan Tadeusz"));
            bookItems.add(createBook("Mały Książę"));
            bookItems.add(createBook("O psie który jeździł koleją"));
            bookItems.add(createBook("W 80 dni dookoła świata"));
            bookItems.add(createBook("Dziady"));
            bookItems.add(createBook("Nie płacz, Koziołku"));
            bookItems.add(createBook("Powrót posła"));
            bookItems.add(createBook("Stara baśń"));
            bookItems.add(createBook("Bartek Zwycięzca"));

            List<User> users = new ArrayList<>();
            users.add(new User("radek@gmail.com", "radek", "radek"));

            Transaction transaction = new Transaction();
            transaction.setBookItem(bookItems.get(2));
            transaction.setUser(users.get(0));
            transaction.setDateFrom(new Date());
            transaction.setTransactionType(TransactionType.RESERVATION);

            entityManager.getTransaction().begin();
            authors.stream().forEach(author -> entityManager.persist(author));
            bookItems.stream().forEach(bookItem -> {
                entityManager.persist(bookItem.getBook());
                entityManager.persist(bookItem);
            });
            users.stream().forEach(user -> entityManager.persist(user));
            entityManager.persist(transaction);

            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();

            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private BookItem createBook(String title) {
        Book book = new Book(title);
        book.getAuthors().add(getRandomAutor());
        BookItem bookItem = new BookItem(book);
        return bookItem;
    }

    private static Date stringToDate(String testDate) throws ParseException {
        return formatter.parse(testDate);
    }

    public Author getRandomAutor() {
        Random r = new Random();
        int high = authors.size();
        return authors.get(r.nextInt(high));
    }

}