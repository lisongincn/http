package exception;

public class InformationInvalidException extends RuntimeException{
    public InformationInvalidException() {
    }

    public InformationInvalidException(String message) {
        super(message);
    }

    public InformationInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public InformationInvalidException(Throwable cause) {
        super(cause);
    }

    public InformationInvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
