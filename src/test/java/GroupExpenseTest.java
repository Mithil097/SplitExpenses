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
        Person personA = new Person("personA");
        Person personB = new Person("personB");
        Person personC = new Person("personC");
        Person personD = new Person("personD");
        Expense expense1 = new Expense(personA, new Money(90.0), Arrays.asList(personA, personB, personC));
        Expense expense2 = new Expense(personB, new Money(120.0), Arrays.asList(personA, personB, personC, personD));
        Expense expense3 = new Expense(personC, new Money(60.0), Arrays.asList(personA, personB, personC));
        GroupExpense trip = new GroupExpense();
        trip.splitExpense(Arrays.asList(expense1, expense2, expense3));
        assertEquals("personA 10.0 personB 40.0 personC -20.0 personD -30.0", personA.personName + " " + personA.getEffectiveMoney() + " " + personB.personName + " " + personB.getEffectiveMoney() + " " + personC.personName + " " + personC.getEffectiveMoney() + " " + personD.personName + " " + personD.getEffectiveMoney());
    }
}