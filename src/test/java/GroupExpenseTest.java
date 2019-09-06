import model.Expense;
import model.GroupExpense;
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
        Person person4 = new Person("person4");
        Expense expense1 = new Expense(person1, new Money(90.0), Arrays.asList(person1, person2, person3));
        Expense expense2 = new Expense(person2, new Money(120.0), Arrays.asList(person1, person2, person3, person4));
        Expense expense3 = new Expense(person3, new Money(60.0), Arrays.asList(person1, person2, person3));
        GroupExpense trip = new GroupExpense();
        trip.splitExpense(Arrays.asList(expense1, expense2, expense3));
        assertEquals("person1 10.0 person2 40.0 person3 -20.0 person4 -30.0", person1.personName + " " + person1.getEffectiveMoney() + " " + person2.personName + " " + person2.getEffectiveMoney() + " " + person3.personName + " " + person3.getEffectiveMoney() + " " + person4.personName + " " + person4.getEffectiveMoney());
    }
}