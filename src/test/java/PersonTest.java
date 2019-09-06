import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {

    @Test
    void expect0WhenCallGetEffectiveMoneyForNewPerson() {
        Person person = new Person("person");
        assertEquals(0.0, person.getEffectiveMoney());
    }

    @Test
    void expect100WhenPersonSpent100() {
        Person person = new Person("person");
        person.addMoneySpent(new Money(100.0));
        assertEquals(100.0, person.getEffectiveMoney());
    }

    @Test
    void expectNegative100WhenPersonOwes100() {
        Person person = new Person("person");
        person.owedMoney(new Money(100.0));
        assertEquals(-100.0, person.getEffectiveMoney());
    }

    @Test
    void expectExceptionWhenPersonSpentNegative100() {
        Person person = new Person("person");
        assertThrows(MoneyCannotBeNegativeException.class, () -> person.addMoneySpent(new Money(-100.0)), "Money cannot be negative ");
    }

    @Test
    void expectExceptionWhenPersonOwesNegative100() {
        Person person = new Person("person");
        assertThrows(MoneyCannotBeNegativeException.class, () -> person.owedMoney(new Money(-100.0)), "Money cannot be negative ");
    }
}

