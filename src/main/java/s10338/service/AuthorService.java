package s10338.service;


import s10338.domain.Author;

public interface AuthorService {

    public void addAuthor(Author author);

    public Author getAuthorById(int authorId);

    public void updateAuthor(Author author);

    public void removeAuthor(int authorId);

}
