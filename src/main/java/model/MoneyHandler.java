package model;

import model.Money;

public interface MoneyHandler {
    Money divide(int numberOfPersons);

    void add(Money money);

    void subtract(Money money);
}

