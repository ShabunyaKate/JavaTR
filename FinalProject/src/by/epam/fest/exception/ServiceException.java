package by.epam.fest.exception;

/**
 * exception that throws in service
 * used like wrapper to DaoException
 */
public class ServiceException extends Exception {
    public ServiceException() {
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}