package exception;

public class WrongUsernameOrPassword extends RuntimeException {
    public WrongUsernameOrPassword(String message) {
        super(message);
    }
}
