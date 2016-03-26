package s10338.domain.repository;

import s10338.domain.Lending;
import s10338.domain.User;

import java.util.List;

public interface UserRepository {

    public void addUser(User user);

    public User getUserByUsername(String username);

    public void updateUser(User user);

    public void removeUser(String username);

    public List<Lending> getUserCommits(String username);

    public void addBook(Lending lending);

}
