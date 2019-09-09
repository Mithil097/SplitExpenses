import exceptions.MoneyCannotBeNegativeException;
import model.Money;
import model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    @Test
    void expect0WhenCallGetEffectiveMoneyForNewPerson() {
        Person person = new Person("person");
        assertEquals(0.0, person.getEffectiveMoney());
    }

    @Test
    void expectMoney100AddedWhenPersonSpent100() {
        Person person = new Person("person");
        Money money = new Money(100.0);
        person.addMoneySpent(money);
        assertEquals(100.0, person.getEffectiveMoney());
    }

    @Test
    void expectSubtractMethodIsCalledWhenPersonOwes100() {
        Person person = new Person("person");
        person.owedMoney(new Money(100.0));
        assertEquals(-100.0, person.getEffectiveMoney());
    }

    @Test
    void expectExceptionWhenPersonSpentNegative100() {
        try {
            Person person = new Person("person");
            person.addMoneySpent(new Money(-100.0));
        } catch (MoneyCannotBeNegativeException exception) {
            assertEquals("Money cannot be negative", exception.getMessage());
        }
    }

    @Test
    void expectExceptionWhenPersonOwesNegative100() {
        try {
            Person person = new Person("person");
            person.owedMoney(new Money(-100.0));
        } catch (MoneyCannotBeNegativeException exception) {
            assertEquals("Money cannot be negative", exception.getMessage());
        }
    }
}

