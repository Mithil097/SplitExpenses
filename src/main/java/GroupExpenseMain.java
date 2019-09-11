import model.Expense;
import model.GroupExpense;
import model.Money;
import model.Person;
import view.Display;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupExpenseMain {
    public static void main(String[] args) {
        Person personA = new Person("personA");
        Person personB = new Person("personB");
        Person personC = new Person("personC");
        Display displayAllPersonDetails = new Display();
        List<Person> personsInvolved = new ArrayList<>();
        personsInvolved.add(personA);
        personsInvolved.add(personB);
        personsInvolved.add(personC);
        Expense expense1 = new Expense(personA, new Money(90.0), personsInvolved);
        Expense expense2 = new Expense(personB, new Money(120.0), personsInvolved);
        Expense expense3 = new Expense(personC, new Money(180.0), personsInvolved);
        GroupExpense trip = new GroupExpense();
        trip.splitExpense(Arrays.asList(expense1, expense2, expense3));
        displayAllPersonDetails.display(personsInvolved);
    }
}
