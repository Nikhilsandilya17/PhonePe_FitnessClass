package exceptions;

public class CancelTimeExceededException extends Exception {
    public CancelTimeExceededException(String message) {
        super(message);
    }
}
