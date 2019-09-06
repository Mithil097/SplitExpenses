import java.util.Objects;

public class Money implements MoneyHandler {
    private double value;

    public Money(double value) {
        if (value < 0.0) {
            throw new MoneyCannotBeNegativeException();
        }
        this.value = value;
    }

    double getMoney() {
        return this.value;
    }

    @Override
    public Money divide(int numberOfPersons) {
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

