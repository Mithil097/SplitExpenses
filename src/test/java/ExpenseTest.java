import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpenseTest {
    @Test
    void expect0WhenPersonSpentOnHimself() {
        Person person = new Person("person1");
        Expense expense = new Expense(person, new Money(10.0), Arrays.asList(person));
        expense.split();
        assertEquals("person1 gets 0.0", expense.Display());
    }

    @Test
    void expectGet10ToPerson1WhenSpentOnPerson2() {
        Person person = new Person("person1");
        Person person2 = new Person("person2");
        Expense expense = new Expense(person, new Money(10.0), Arrays.asList(person2));
        expense.split();
        assertEquals("person1 gets 10.0", expense.Display());
    }

    @Test
    void expectGet10ToPerson2WhenSpentOnPerson1() {
        Person person1 = new Person("person1");
        Person person2 = new Person("person2");
        Expense expense = new Expense(person2, new Money(10.0), Arrays.asList(person1));
        expense.split();
        assertEquals("person2 gets 10.0", expense.Display());
    }

    @Test
    void expectGet50ToPerson1WhenSpent100OnHimAndPerson2() {
        Person person1 = new Person("person1");
        Person person2 = new Person("person2");
        Expense expense = new Expense(person1, new Money(100.0), Arrays.asList(person1, person2));
        expense.split();
        assertEquals("person1 gets 50.0", expense.Display());
    }
}
