package s10338.sandbox;

import s10338.domain.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

//    public static void main(String[] args) {
//        Gielda gielda = new Gielda();
////        gielda.setData();
//    }

    public static void main(String[] args) {
        try {

            List<Author> authors = new ArrayList<>();
            authors.add(new Author("Adam"));
            authors.add(new Author("Jan"));
            authors.add(new Author("Marcin"));
            authors.add(new Author("Robert"));
            authors.add(new Author("Anna"));
            authors.add(new Author("Leopold"));

            int i = 0;

//            for (int j = 0; j < 10; j++) {
                System.out.println("Save Customers");
//            }

            entityManager.getTransaction().begin();
            authors.stream().forEach(author -> entityManager.persist(author));
            entityManager.getTransaction().commit();

//            entityManager.persist(new Customer("Radek", "Warszawa"));
//            entityManager.persist(new Customer("Jacek", "Radom"));
//            entityManager.persist(new Customer("Monika", "Warszawa"));
//            entityManager.persist(new Customer("Weronika"));
//            entityManager.persist(new Customer("Oliwia", "Warszawa"));
//            entityManager.persist(new Customer("Marta"));


            entityManager.close();
            entityManagerFactory.close();

//            System.out.println("book.getTitle() " + book.getTitle());

            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Date stringToDate(String testDate) throws ParseException {
        return formatter.parse(testDate);
    }

//    private static void saveBook(String title, String name, String lastName, Date date, int number) {
//        Book book = new Book();
//
//        book.setTitle(title);
//        book.setAutorFirstName(name);
//        book.setAutorLastName(lastName);
//        book.setDateRelease(date);
//        book.setNumberPages(number);
//        entityManager.persist(book);
//
//    }


}