package just4.fun.smallshop.services;

/**
 * Created by zinchenko on 14.03.15.
 */
public class UnexpectedServiceException extends RuntimeException {
    public UnexpectedServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
