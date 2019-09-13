package model;

import exceptions.MoneyCannotBeNegativeException;
import interfaces.MoneyHandler;

import java.util.Objects;
import java.util.logging.Logger;

public class Money implements MoneyHandler {
    private double value;
    Logger logger= Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Money(double value) {

        logger.severe("money cannot be negative");
        if (value < 0.0) {
            throw new MoneyCannotBeNegativeException("Money cannot be negative");
        }
        this.value = value;
    }

    public double getMoney() {
        return this.value;
    }

    @Override
    public Money divide(int numberOfPersons) {
        logger.info("money spent is divided here");
        return new Money(this.value / numberOfPersons);
    }

    @Override
    public void add(Money money) {
        this.value += money.value;
    }

    @Override
    public void subtract(Money money) {
        this.value -= money.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(money.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}

