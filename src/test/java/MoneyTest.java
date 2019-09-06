import exceptions.MoneyCannotBeNegativeException;
import model.Money;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTest {

    @Test
    void expect10WhenMoneyCallsGetMoney() {
        Money money = new Money(10.0);
        assertEquals(10.0, money.getMoney());
    }

    @Test
    void expectMoney10WhenNewMoney10AddToMoney() {
        Money money = new Money(0.0);
        money.add(new Money(10.0));
        assertEquals(new Money(10.0), money);
    }

    @Test
    void expectMoney10WhenNewMoney90SubtractToMoney() {
        Money money = new Money(100.0);
        money.subtract(new Money(90.0));
        assertEquals(new Money(10.0), money);
    }

    @Test
    void expectMoneyCannotBeNegativeExceptionWhenMoneyHasNegativeValue() {
        try {
            Money money = new Money(-10.0);
        } catch (MoneyCannotBeNegativeException exception) {
            assertEquals("model.Money cannot be negative", exception.getMessage());
        }
    }

    @Test
    void expectMoney10WhenMoneyDivide10Persons() {
        Money money = new Money(100.0);
        assertEquals(new Money(10.0), money.divide(10));
    }
}

