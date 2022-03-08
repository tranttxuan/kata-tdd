package tdd.exceptions;

public class InvalidListException extends RuntimeException {
    public InvalidListException(String arg) {
        super(arg);
    }
}
