import controller.ShareExpense;
import model.Expense;
import model.Money;
import model.Person;
import view.Display;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExpenseMain {
    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        logger.log(Level.INFO, "My first log");
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
        ShareExpense share=new ShareExpense(personsInvolved,display);
        share.share();
    }
}