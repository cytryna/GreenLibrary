package s10338.domain.repository;

import s10338.domain.Author;

import java.util.List;

public interface AuthorReository {

    public void addAuthor(Author author);

    public Author getAuthorById(int authorId);

    public void updateAuthor(Author author);

    public void removeAuthor(int authorId);

    public List<Author> getBookAuthors(int bookId);
}
