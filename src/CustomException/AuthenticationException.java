package CustomException;

public class AuthenticationException extends Exception {
	public AuthenticationException(String msg) {
		super(msg);
	}
}
