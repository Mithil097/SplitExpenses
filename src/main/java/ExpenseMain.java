import model.Expense;
import model.Money;
import model.Person;
import view.Display;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpenseMain {
    public static void main(String[] args) {
        Person person1 = new Person("person1");
        Person person2 = new Person("person2");
        Person person3 = new Person("person3");
        Display display = new Display();
        Money moneySpent = new Money(90.0);
        List<Person> personsInvolved = new ArrayList<>();
        personsInvolved.add(person1);
        personsInvolved.add(person2);
        personsInvolved.add(person3);
        Expense expense = new Expense(person1, moneySpent, Arrays.asList(person1, person2, person3));
        expense.split();
        display.display(personsInvolved);
    }
}