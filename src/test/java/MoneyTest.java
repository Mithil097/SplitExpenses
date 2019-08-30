import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {
    @Test
    void expect10WhenMoneyAddToAPerson(){
        Money money=new Money(0.0);
        money.add(new Money(10.0));
        assertEquals(new Money(10.0), money);
    }
    @Test
    void expect10WhenMoneySubtractToAPerson(){
        Money money=new Money(100.0);
        money.subtract(new Money(90.0));
        assertEquals(new Money(10.0), money);
    }
}
