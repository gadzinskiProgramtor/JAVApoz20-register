package pl.sda.register.service;

import org.springframework.stereotype.Service;
import pl.sda.register.model.User;
import pl.sda.register.repository.UserRepository;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Set<String> findAllUserNames(String firstName, boolean matchExact) {
        if (firstName == null) {
            return userRepository.findAllUserNames();
        }
        return userRepository.findUserNamesByFirstName(firstName, matchExact);
    }

    public User findUserByUserName(String username) {
        return userRepository.findUserByUsername(username);
    }

    public void addUser(User user) {
        userRepository.add(user);
    }

    public void removeByUsername(String username) {
        userRepository.removeByUsername(username);
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }
}
