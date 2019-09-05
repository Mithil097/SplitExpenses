public interface MoneyHandler {
    Money divide(int numberOfPersons);

    void add(Money moneySpent);

    void subtract(Money moneySpent);
}
