import model.Expense;
import model.GroupExpense;
import model.Money;
import model.Person;
import view.Display;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GroupExpenseMain {
    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        logger.log(Level.INFO, "My first log");
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
