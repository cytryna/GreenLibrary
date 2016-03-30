package s10338.service;

import s10338.domain.BookItem;
import s10338.domain.Transaction;
import s10338.domain.User;

import java.util.List;

public interface UserService {

    public void addUser(User user);

    public User getUserByUsername(String username);

    public void updateUser(User user);

    public void removeUser(String username);

    public void commitBook(String username, BookItem book, Transaction transaction);

    public List<Transaction> getUserCommits(String username);

}
