import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonTest {
    @Test
    void expectPerson1Gets100WhenPersonSpent100() {
        Person person1 = new Person("person1");
        person1.addMoneySpentByMe(new Money(100.0));
        assertEquals("person1 Gets 100.0", person1.toString());
    }

    @Test
    void expectPerson1Gives100WhenPersonOwes100() {
        Person person1 = new Person("person1");
        person1.owesMoneySpentOnMe(new Money(100.0));
        assertEquals("person1 Gives 100.0", person1.toString());
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
