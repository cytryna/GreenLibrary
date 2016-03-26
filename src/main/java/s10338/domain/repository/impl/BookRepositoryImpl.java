package s10338.domain.repository.impl;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import s10338.domain.Book;
import s10338.domain.Customer;
import s10338.domain.repository.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int addBook(Book book) {
        entityManager.persist(book);
        return book.getId();
    }

    @Override
    public Book getBookById(int id) {
        Book book = null;
        try {
            book = entityManager.find(Book.class, id);
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        Query query = entityManager.createQuery("SELECT e FROM Book e");
        return (List<Book>) query.getResultList();
    }

    @Override
    public void updateBook(Book book) {
        entityManager.merge(book);
    }

    @Override
    public void removeBook(int id) {

    }

}
