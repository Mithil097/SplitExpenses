import exceptions.MoneyCannotBeNegativeException;
import model.Money;
import model.Person;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.reflection.FieldSetter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PersonTest {

    @Test
    void expect0WhenCallGetEffectiveMoneyForPerson() {
        Person person = new Person("person");
        assertEquals(0.0, person.getEffectiveMoney());
    }

    @Test
    void expectAddMethodCalledInMoneyAddedWhenPersonCalledAddMoneySpent() throws NoSuchFieldException {
        Person person = new Person("person");
        Money mockedMoney = mock(Money.class);
        Money money = mock(Money.class);
        FieldSetter.setField(person, person.getClass().getDeclaredField("effectiveMoney"), mockedMoney);
        person.addMoneySpent(money);
        verify(mockedMoney).add(money);
    }

    @Test
    void expectSubtractCalledInMoneyWhenPersonCalledSubtractOwedMoney() throws NoSuchFieldException {
        Person person = new Person("person");
        Money mockedMoney = mock(Money.class);
        Money money = mock(Money.class);
        FieldSetter.setField(person, person.getClass().getDeclaredField("effectiveMoney"), mockedMoney);
        person.subtractOwedMoney(money);
        verify(mockedMoney).subtract(money);
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
            person.subtractOwedMoney(new Money(-100.0));
        } catch (MoneyCannotBeNegativeException exception) {
            assertEquals("Money cannot be negative", exception.getMessage());
        }
    }

    @Test
    void expect0WhenPersonCallsGetEffectiveMoney() {
        Person person = new Person("person1");
        assertEquals(0.0, person.getEffectiveMoney());
    }

    @Test
    void expectFalseWhenPersonCalledIsOwed() {
        Person person = new Person("person1");
        assertFalse(person.isOwed());
    }

    @Test
    void expectMoney10OwedPersonWhenPersonSubtractOwedMoney() {
        Person person = new Person("person");
        person.subtractOwedMoney(new Money(10.0));
        assertEquals(10.0, person.getOwedMoney());
    }
}

