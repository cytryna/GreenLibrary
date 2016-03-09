package s10338.main.sandbox;

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

            for (int j = 0; j < 10; j++) {
                System.out.println(j);
            }


//        Employee employee  = new Employee();
//        employee.setFirstName("Jan");
//        employee.setLastName("Nowak");
//        employee.setSalary(443.0);
//            LocalDate.parse("1981-01-19")
            entityManager.getTransaction().begin();


            saveBook("Lalka", "Bolesław", "Prus", stringToDate("1981-01-19"), 112);
            saveBook("W pustyni i w puszczy", "Henryk", "Sienkiewicz", stringToDate("2011-01-19"), 113);
            saveBook("Dziady", "Adma", "Mickiewicz", stringToDate("2010-11-09"), 302);
            entityManager.getTransaction().commit();


//            Book book = entityManager.find(Book.class, 1L);
//            entityManager.persist(autor);
//            entityManager.persist(book);

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