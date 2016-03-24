package s10338.domain.dao;

import s10338.domain.Commit;
import s10338.domain.User;

import java.util.List;

public interface UserDao {

    public void addUser(User user);

    public User getUserByUsername(String username);

    public void updateUser(User user);

    public void removeUser(String username);

    public List<Commit> getUserCommits(String username);

    public void addBook(Commit commit);

}
