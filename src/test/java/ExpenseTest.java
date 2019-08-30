import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpenseTest {
    @Test
    void expect0WhenASpentOnHimself() {
        Person person = new Person("person1");
        Expense expense = new Expense(person, new Money(10.0));
        expense.split();
        assertEquals("person1 has 0.0", expense.Display());
    }
}
