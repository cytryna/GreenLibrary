package s10338.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import s10338.domain.Author;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Override
    @Transactional
    public void addAuthor(Author author) {

    }

    @Override
    @Transactional
    public Author getAuthorById(int authorId) {
        return null;
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {

    }

    @Override
    @Transactional
    public void removeAuthor(int authorId) {

    }
}
