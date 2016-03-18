package s10338.sandbox;

import s10338.domain.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

            System.out.println("yo");
            int i = 0;

//            for (int j = 0; j < 10; j++) {
                System.out.println("Save Customers");
//            }

            entityManager.getTransaction().begin();

            entityManager.persist(new Customer("Radek", "Warszawa"));
            entityManager.persist(new Customer("Jacek", "Radom"));
            entityManager.persist(new Customer("Monika", "Warszawa"));
            entityManager.persist(new Customer("Weronika"));
            entityManager.persist(new Customer("Oliwia", "Warszawa"));
            entityManager.persist(new Customer("Marta"));

            entityManager.getTransaction().commit();

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

    private static void saveBook(String title, String name, String lastName, Date date, int number) {
        Book book = new Book();
//            Autor autor = new Autor();
//            autor.setLastName("Nowak");
//            book.setAutor(autor);
        book.setTitle(title);
        book.setAutorFirstName(name);
        book.setAutorLastName(lastName);
        book.setDateRelease(date);
        book.setNumberPages(number);
        entityManager.persist(book);

    }


}