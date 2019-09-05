class MoneyCannotBeNegativeException extends RuntimeException {
    MoneyCannotBeNegativeException() {
        super("Money cannot be negative ");
    }
}
