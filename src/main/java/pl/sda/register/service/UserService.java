package pl.sda.register.service;

import org.springframework.stereotype.Service;
import pl.sda.register.dao.UserDao;
import pl.sda.register.dao.UserDaoImpl;
import pl.sda.register.model.User;
import pl.sda.register.repository.UserRepository;

import java.sql.SQLException;
import java.util.Set;

@Service
public class UserService {

    private UserDao userDao = UserDaoImpl.getInstance();

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Set<String> findAllUserNames() {
        return userDao.findAllUserNames();
//        return userRepository.findAllUserNames();
    }
    public Set<String> findAllUserNames(String firstName, Boolean matchExact)  {
        return userDao.findAllUserNames(firstName, matchExact);
//        return userRepository.findAllUserNames(firstName, matchExact);
    }

    public User findUserByUserName(String username) {

        return userDao.findUserByUsername(username);
//        return userRepository.findUserByUsername(username);
    }

    public void addUser(User user) {
        userDao.addUser(user);
//        userRepository.addUser(user);
    }

    public void removeUser(String username) {
        userDao.removeUser(username);
//        userRepository.removeUser(username);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
//        userRepository.updateUser(user);
    }
}
