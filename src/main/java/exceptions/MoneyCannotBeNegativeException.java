package exceptions;

public class MoneyCannotBeNegativeException extends RuntimeException {
    public MoneyCannotBeNegativeException(String exceptionMessage) {
        super(exceptionMessage);
    }
}

