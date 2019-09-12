import model.Expense;
import model.GroupExpense;
import model.Money;
import model.Person;
import view.Display;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.*;

public class GroupExpenseMain {
    private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static void setUpLogger() throws IOException {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);
        Handler handler = new FileHandler("log.xml");
        handler.setLevel(Level.INFO);
        handler.setFormatter(new XMLFormatter());
        logger.addHandler(handler);
        logger.info("start the logger");
    }
    public static void main(String[] args) throws IOException {
        setUpLogger();
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
    }
}
