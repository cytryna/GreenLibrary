package s10338.service;


import s10338.domain.Book;

import java.util.List;

public interface BookService {

    public int addBook(Book book);

    public Book getBookById(int bookId);

    public Book getBookByTitle(String title);

    public List<Book> getAllBooks();

    public void updateBook(Book book);

    public void removeBook(int bookId);

}
