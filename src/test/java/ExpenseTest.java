import exceptions.MoneyCannotBeNegativeException;
import model.Expense;
import model.Money;
import model.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpenseTest {
    @Test
    void expectPersonHas0MoneyWhenPersonSpentOnHimself() {
        Person person = new Person("person");
        Expense expense = new Expense(person, new Money(10.0), Arrays.asList(person));
        expense.split();
        assertEquals(0.0, person.getEffectiveMoney());
    }

    @Test
    void expectPerson2HasNegative10WhenPerson1SpentOnPerson2() {
        Person person1 = new Person("person1");
        Person person2 = new Person("person2");
        Money money = new Money(10.0);
        Expense expense = new Expense(person1, money, Arrays.asList(person2));
        expense.split();
        assertEquals(-10.0, person2.getEffectiveMoney());
    }

    @Test
    void expectPerson1HasMoney50Person2MoneyNegative50WhenPerson1Spent100OnHimAndPerson2() {
        Person person1 = new Person("person1");
        Person person2 = new Person("person2");
        Expense expense = new Expense(person1, new Money(100.0), Arrays.asList(person1, person2));
        expense.split();
        assertEquals("person1 50.0 person2 -50.0", person1.personName + " " + person1.getEffectiveMoney() + " " + person2.personName + " " + person2.getEffectiveMoney());
    }

    @Test
    void expectExceptionWhenPersonSpentNegative100() {
        try {
            Person person1 = new Person("person1");
            Person person2 = new Person("person2");
            Expense expense = new Expense(person1, new Money(-100.0), Arrays.asList(person1, person2));
        } catch (MoneyCannotBeNegativeException exception) {
            assertEquals("Money cannot be negative", exception.getMessage());
        }
    }
}

