package exception;

public class UsernameAreadyUsed extends RuntimeException {
    public UsernameAreadyUsed(String message) {
        super(message);
    }
}
