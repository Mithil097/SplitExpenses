import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpenseTest {
    @Test
    void expectPerson1Gets0WhenPerson1SpentOnHimself() {
        Person person1 = new Person("person1");
        Expense expense = new Expense(person1, new Money(10.0), Arrays.asList(person1));
        expense.split();
        assertEquals("person1 Gets 0.0", expense.Display());
    }

    @Test
    void expectPerson1Gets10WhenPerson1SpentOnPerson2() {
        Person person1 = new Person("person1");
        Person person2 = new Person("person2");
        Expense expense = new Expense(person1, new Money(10.0), Arrays.asList(person2));
        expense.split();
        assertEquals("person1 Gets 10.0", expense.Display());
    }

    @Test
    void expectPerson1Get50ToPerson1WhenSpent100OnHimAndPerson2() {
        Person person1 = new Person("person1");
        Person person2 = new Person("person2");
        Expense expense = new Expense(person1, new Money(100.0), Arrays.asList(person1, person2));
        expense.split();
        assertEquals("person1 Gets 50.0", expense.Display());
    }
}
