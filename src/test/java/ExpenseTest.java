import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpenseTest {
    @Test
    void expect0WhenPersonSpentOnHimself() {
        Person person = new Person("person1");
        Expense expense = new Expense(person, new Money(10.0),person);
        expense.split();
        assertEquals("person1 gets 0.0", expense.Display());
    }
    @Test
    void expectGet10ToPerson1WhenSpentOnPerson2() {
        Person person = new Person("person1");
        Person person2=new Person("person2");
        Expense expense = new Expense(person, new Money(10.0),person2);
        expense.split();
        assertEquals("person1 gets 10.0", expense.Display());
    }
    @Test
    void expectGet10ToPerson2WhenSpentOnPerson1() {
        Person person1 = new Person("person1");
        Person person2=new Person("person2");
        Expense expense = new Expense(person2, new Money(10.0),person1);
        expense.split();
        assertEquals("person2 gets 10.0", expense.Display());
    }
}
