import java.util.Objects;

public class Money {
    private double value;

    public Money(double value) {
        this.value = value;
    }

    void add(Money moneySpent) {
        this.value += moneySpent.value;
    }

    void subtract(Money moneySpent) {
        this.value -= moneySpent.value;
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

    @Override
    public String toString() {
        return "" + value;
    }
}
