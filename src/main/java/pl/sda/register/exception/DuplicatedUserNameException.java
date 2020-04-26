package pl.sda.register.exception;

public class DuplicatedUserNameException extends RuntimeException {

    public DuplicatedUserNameException(String username) {
        super("user "+username+" already exist");
    }
}
