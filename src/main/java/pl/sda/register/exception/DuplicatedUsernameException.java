package pl.sda.register.exception;

public class DuplicatedUsernameException extends RuntimeException {

    public DuplicatedUsernameException(String username) {
        super("User already exists with given username " + username);
    }
}
