package pl.sda.register.repository;

import org.springframework.stereotype.Repository;
import pl.sda.register.exception.DuplicatedUsernameException;
import pl.sda.register.exception.UserNotFoundException;
import pl.sda.register.model.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    private Set<User> users = initializeUsers();

    private Set<User> initializeUsers() {
        return new HashSet<>(Arrays.asList(new User("login", "Captain", "Jack")));
    }

    public Set<String> findAllUserNames() {
        return users.stream().map(User::getUsername).collect(Collectors.toSet());
    }

    public User findUserByUsername(String username) {
        return users.stream()
            .filter(user -> user.getUsername().equals(username))
            .findAny()
            .orElseThrow(() -> new UserNotFoundException("User with username: " + username + " not found"));
    }

    public void add(User user) {
        Optional<User> userWithExistingUsername = users.stream()
            .filter(currentUser -> currentUser.getUsername().equals(user.getUsername())).findAny();
        if (userWithExistingUsername.isPresent()) {
            throw new DuplicatedUsernameException(user.getUsername());
        }
        users.add(user);
    }

    public Set<String> findUserNamesByFirstName(String firstName, boolean matchExact) {
        return users.stream()
            .filter(getUserPredicate(firstName, matchExact))
            .map(User::getUsername)
            .collect(Collectors.toSet());
    }

    private Predicate<User> getUserPredicate(String firstName, boolean matchExact) {
        return matchExact ?
            user -> firstName.equals(user.getFirstName()) :
            user -> user.getFirstName().contains(firstName);
    }

    public void removeByUsername(String username) {
        users.remove(findUserByUsername(username));
    }

    public void update(User user) {
        removeByUsername(user.getUsername());
        add(user);
    }
}
