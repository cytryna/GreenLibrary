package s10338.domain.repository.impl;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import s10338.domain.Book;
import s10338.domain.repository.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;
    private List<Book> bookList = new ArrayList<Book>();

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
    public Book getConcreteBookByTitle(String title) {
        Book book = null;
        try {
            book = entityManager.find(Book.class, title);
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        refreshBooks();
        return bookList;
    }

    private void refreshBooks() {
        if (bookList == null || bookList.isEmpty()) {
            Query query = entityManager.createQuery("SELECT e FROM Book e");
//            SELECT book_item.id , book.title, transaction.dateFrom FROM book_item
//            inner join book on book_item.book_id = book.id
//            left outer join transaction on transaction.book_item_id = book_item.id
//            WHERE transaction.dateTo is null or book_item.id not in (select book_item_id from transaction)
            bookList = query.getResultList();
        }
    }

    @Override
    public void updateBook(Book book) {
        entityManager.merge(book);
    }

    @Override
    public void removeBook(int id) {

    }

    @Override
    public List<Book> getBookByTitle(String title) {
        refreshBooks();
        return bookList.stream()
                .filter(book -> book.getTitle().contains(title))
                .collect(Collectors.toList());
    }

}
