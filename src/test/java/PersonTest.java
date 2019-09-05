import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {
    @Test
    void expect100WhenPersonSpent100() {
        Person person = new Person("person");
        person.addMoneySpentByMe(new Money(100.0));
        assertEquals("person gets 100.0", person.toString());
    }

    @Test
    void expectNegative100WhenPersonOwes100() {
        Person person = new Person("person");
        person.owesMoneySpentOnMe(new Money(100.0));
        assertEquals("person gets -100.0", person.toString());
    }

    @Test
    void expectExceptionWhenPersonSpentNegative100() {
        Person person = new Person("person");
        assertThrows(MoneyCannotBeNegativeException.class, () -> person.addMoneySpentByMe(new Money(-100.0)));
    }

    @Test
    void expectExceptionWhenPersonOwesNegative100() {
        Person person = new Person("person");
        assertThrows(MoneyCannotBeNegativeException.class, () -> person.owesMoneySpentOnMe(new Money(-100.0)));
    }
}
