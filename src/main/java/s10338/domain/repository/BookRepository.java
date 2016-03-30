package s10338.domain.repository;


import s10338.domain.BookItem;

import java.util.List;

public interface BookRepository {

    int addBook(BookItem book);

    BookItem getBookById(int bookId);

    List<BookItem> getAllBooks();

    void updateBook(BookItem book);

    void removeBook(int bookId);

    List<BookItem> getBookByTitle(String title);
}
