import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyTest {
    @Test
    void expect10WhenNewMoneyAddToMoney1() {
        Money money1 = new Money(0.0);
        money1.add(new Money(10.0));
        assertEquals(new Money(10.0), money1);
    }

    @Test
    void expect10WhenNewMoneySubtractToMoney1() {
        Money money1 = new Money(100.0);
        money1.subtract(new Money(90.0));
        assertEquals(new Money(10.0), money1);
    }

    @Test
    void expectExceptionMoneyHasNegativeValue() {
        assertThrows(MoneyCannotBeNegativeException.class, () -> new Money(-10.0));
    }

    @Test
    void expect10WhenMoney1DivideWithListOfPersons() {
        Money money1 = new Money(100.0);
        assertEquals(new Money(10.0), money1.divide(10));
    }

}
