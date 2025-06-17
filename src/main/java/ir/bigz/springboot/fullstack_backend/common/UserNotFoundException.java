package ir.bigz.springboot.fullstack_backend.common;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super(String.format("could not find User with %s", id));
    }
}
