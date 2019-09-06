import controller.Expense;
import exceptions.MoneyCannotBeNegativeException;
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
        assertEquals("person 0.0\t", expense.display());
    }

    @Test
    void expectPerson1HasMoney10AndPerson2HasNegative10WhenPerson1SpentOnPerson2() throws Exception, MoneyCannotBeNegativeException {
        Person person1 = new Person("person1");
        Person person2 = new Person("person2");
        Expense expense = new Expense(person1, new Money(10.0), Arrays.asList(person2));
        expense.split();
        assertEquals("person1 10.0\tperson2 -10.0\t", expense.display());
    }

    @Test
    void expectPerson1HasMoney50Person2MoneyNegative50WhenPerson1Spent100OnHimAndPerson2() throws Exception, MoneyCannotBeNegativeException {
        Person person1 = new Person("person1");
        Person person2 = new Person("person2");
        Expense expense = new Expense(person1, new Money(100.0), Arrays.asList(person1, person2));
        expense.split();
        assertEquals("person1 50.0\tperson2 -50.0\t", expense.display());
    }

    @Test
    void expectExceptionWhenPersonSpentNegative100() {
        try {
            Person person1 = new Person("person1");
            Person person2 = new Person("person2");
            Expense expense = new Expense(person1, new Money(-100.0), Arrays.asList(person1, person2));
        } catch (MoneyCannotBeNegativeException exception) {
            assertEquals("model.Money cannot be negative", exception.getMessage());
        }
    }
}

