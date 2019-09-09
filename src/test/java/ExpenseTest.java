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
        Person personA = new Person("personA");
        Person personB = new Person("personB");
        Money money = new Money(10.0);
        Expense expense = new Expense(personA, money, Arrays.asList(personB));
        expense.split();
        assertEquals(-10.0, personB.getEffectiveMoney());
    }

    @Test
    void expectPerson1HasMoney50Person2MoneyNegative50WhenPerson1Spent100OnHimAndPerson2() {
        Person personA = new Person("personA");
        Person personB = new Person("personB");
        Expense expense = new Expense(personA, new Money(100.0), Arrays.asList(personA, personB));
        expense.split();
        assertEquals("personA 50.0 personB -50.0", personA.personName + " " + personA.getEffectiveMoney() + " " + personB.personName + " " + personB.getEffectiveMoney());
    }

    @Test
    void expectExceptionWhenPersonSpentNegative100() {
        try {
            Person personA = new Person("personA");
            Person personB = new Person("personB");
            Expense expense = new Expense(personA, new Money(-100.0), Arrays.asList(personA, personB));
        } catch (MoneyCannotBeNegativeException exception) {
            assertEquals("Money cannot be negative", exception.getMessage());
        }
    }
}

