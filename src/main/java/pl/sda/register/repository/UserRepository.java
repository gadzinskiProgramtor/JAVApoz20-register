package pl.sda.register.repository;

import org.springframework.stereotype.Repository;
import pl.sda.register.exception.DuplicatedUserNameException;
import pl.sda.register.exception.UserNotFoundException;
import pl.sda.register.model.User;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

@Repository
public class UserRepository {

    private Set<User> users = initializeUsers();

    private Set<User> initializeUsers() {
        return new HashSet<>(Arrays.asList(new User("login", "Captain", "Jack")));
    }

    public Set<String> findAllUserNames() {
        return users.stream().map(User::getUsername).collect(Collectors.toSet());
    }

    public Set<String> findAllUserNames(String firstName, Boolean matchExact) {
        if (matchExact != false) {
            return users.stream()
                    .filter(user -> user.getFirstName().equals(firstName))
                    .map(User::getUsername)
                    .collect(Collectors.toSet());
        } else {
            return users.stream()
                    .filter(user -> user.getFirstName().contains(firstName))
                    .map(User::getUsername)
                    .collect(Collectors.toSet());
        }
    }

    public User findUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findAny()
                .orElseThrow(() -> new UserNotFoundException("User with username: " + username + " not found"));
    }

    public void addUser(User user) {
        Optional<User> userExisting = users.stream()
                .filter(user1 -> user1.getUsername().equals(user.getUsername()))
                .findAny();
        if (userExisting.isPresent()) {
            throw new DuplicatedUserNameException(user.getUsername());
        }
        users.add(user);

    }

    public void removeUser(String username) {
        users.remove(findUserByUsername(username));
    }
}
