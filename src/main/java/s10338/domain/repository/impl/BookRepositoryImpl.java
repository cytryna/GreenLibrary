package s10338.domain.repository.impl;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import s10338.domain.BookItem;
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
    private List<BookItem> bookList = new ArrayList<BookItem>();

    @Override
    public int addBook(BookItem book) {
        entityManager.persist(book);
        return book.getId();
    }

    @Override
    public BookItem getBookById(int id) {
        BookItem book = null;
        try {
            book = entityManager.find(BookItem.class, id);
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
        return book;
    }

    @Override
    public List<BookItem> getAllBooks() {
        refreshBooks();
        return bookList;
    }

    private void refreshBooks() {
        if (bookList == null || bookList.isEmpty()) {
            Query query = entityManager.createQuery("SELECT e FROM BookItem e");
            bookList = query.getResultList();
        }
    }

    @Override
    public void updateBook(BookItem book) {
        entityManager.merge(book);
    }

    @Override
    public void removeBook(int id) {

    }

    @Override
    public List<BookItem> getBookByTitle(String title) {
        refreshBooks();
        return bookList.stream()
                .filter(book -> book.getTitle().contains(title))
                .collect(Collectors.toList());
    }

}
