package pl.sda.register.dao;

import pl.sda.register.model.User;

import java.sql.SQLException;
import java.util.Set;

public interface UserDao {
    public Set<String> findAllUserNames();
    public Set<String> findAllUserNames(String firstName, Boolean matchExact);
    public User findUserByUsername(String username);
    public void addUser(User user);
    public boolean isUserPresent(String username);
    public void removeUser(String username);
    public void updateUser(User user);
}
