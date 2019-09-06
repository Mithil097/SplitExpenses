import model.Expense;
import model.Money;
import model.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupExpenseTest {
    @Test
    void expectAllPersonsEffectiveMoneyWhoInvolvedInGroupExpense() {
        Person person1 = new Person("person1");
        Person person2 = new Person("person2");
        Person person3 = new Person("person3");
        Expense expense1 = new Expense(person1, new Money(90.0), Arrays.asList(person1, person2, person3));
        Expense expense2 = new Expense(person2, new Money(120.0), Arrays.asList(person1, person2, person3));
        Expense expense3 = new Expense(person3, new Money(60.0), Arrays.asList(person1, person2, person3));
        model.GroupExpense trip = new model.GroupExpense();
        trip.splitExpense(Arrays.asList(expense1, expense2, expense3));
        assertEquals("person1 0.0 person2 30.0 person3 -30.0", person1.personName + " " + person1.getEffectiveMoney() + " " + person2.personName + " " + person2.getEffectiveMoney() + " " + person3.personName + " " + person3.getEffectiveMoney());
    }
}