package s10338.service;


import s10338.domain.BookItem;

import java.util.List;

public interface BookService {

    int addBook(BookItem book);

    BookItem getBookById(int bookId);

    List<BookItem> getBookByTitle(String title);

    List<BookItem> getAllBooks();

    void updateBook(BookItem book);

    void removeBook(int bookId);

}
