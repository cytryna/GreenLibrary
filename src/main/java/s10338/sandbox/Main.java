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
//    private List<Author> authors;

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        try {
            Author authorTemorary1;
            Book bookTemporary;

            entityManager.getTransaction().begin();

            authorTemorary1 = new Author("Adam Mickiewicz");//stworzenie autora w pamieci
            entityManager.persist(authorTemorary1);//zapis do bazy

            bookTemporary = new Book("Pan Tadeusz");//stworzenei książki w pamięci
            bookTemporary.setAuthor(authorTemorary1);
            entityManager.persist(bookTemporary);//zapias do bazy

            bookTemporary = new Book("Sonety Krymskie");//stworzenei książki w pamięci
            bookTemporary.setAuthor(authorTemorary1);
            entityManager.persist(bookTemporary);//zapias do bazy

            List<User> users = new ArrayList<>();
            users.add(new User("radek@gmail.com", "radek", "radek"));
            users.stream().forEach(user -> entityManager.persist(user));


//            Transaction transaction = new Transaction();
//            transaction.setBook(books.get(2));
//            transaction.setUser(users.get(0));
//            transaction.setDateFrom(new Date());
//            transaction.setTransactionType(TransactionType.RESERVATION);

//            authors.stream().forEach(author -> entityManager.persist(author));
//            books.stream().forEach(bookItem -> {
//                entityManager.persist(bookItem);
//            });
//            entityManager.persist(transaction);

            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();

            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private Book createBook(String title) {
//        Book book = new Book(title);
//        book.getAuthors().add(getRandomAutor());
//        return book;
//    }

    private static Date stringToDate(String testDate) throws ParseException {
        return formatter.parse(testDate);
    }

//    public Author getRandomAutor() {
//        Random r = new Random();
//        int high = authors.size();
//        return authors.get(r.nextInt(high));
//    }

}