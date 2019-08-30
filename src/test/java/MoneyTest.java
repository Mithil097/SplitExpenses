import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoneyTest {
    @Test
    void expect10WhenMoneyAddToAPerson() {
        Money money = new Money(0.0);
        money.add(new Money(10.0));
        assertEquals(new Money(10.0), money);
    }

    @Test
    void expect10WhenMoneySubtractToAPerson() {
        Money money = new Money(100.0);
        money.subtract(new Money(90.0));
        assertEquals(new Money(10.0), money);
    }

    @Test
    void expectExceptionMoneyHasNegativeValue() {
        assertThrows(MoneyCannotBeNegativeException.class, () -> new Money(-10.0));
    }

    @Test
    void expect10WhenMoneyShareToListOfPersons() {
        Money money = new Money(100.0);
        assertEquals(new Money(10.0), money.share(10));
    }

}
