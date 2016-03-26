package s10338.domain.repository;


import s10338.domain.Book;

import java.util.List;

public interface BookRepository {

    public int addBook(Book book);

    public Book getBookById(int bookId);

    public List<Book> getAllBooks();

    public void updateBook(Book book);

    public void removeBook(int bookId);

}
