import controller.ShareExpense;
import model.Expense;
import model.GroupExpense;
import model.Money;
import model.Person;
import view.Display;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class GroupExpenseMain {
    private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        logger.info("start the logger");
        Person personA = new Person("personA");
        Person personB = new Person("personB");
        Person personC = new Person("personC");
        Person personD = new Person("personD");
        Display display = new Display();
        List<Person> personsInvolved = new ArrayList<>();
        personsInvolved.add(personA);
        personsInvolved.add(personB);
        personsInvolved.add(personC);
        personsInvolved.add(personD);
        Expense expense1 = new Expense(personA, new Money(240.0), personsInvolved);
        Expense expense2 = new Expense(personB, new Money(160.0), personsInvolved);
        Expense expense3 = new Expense(personC, new Money(120.0), personsInvolved);
        Expense expense4 = new Expense(personD, new Money(180.0), personsInvolved);
        GroupExpense trip = new GroupExpense();
        trip.splitExpense(Arrays.asList(expense1, expense2, expense3, expense4));
        ShareExpense share = new ShareExpense(personsInvolved, display);
        share.share();
    }
}
