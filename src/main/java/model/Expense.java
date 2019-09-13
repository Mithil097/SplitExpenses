package model;

import java.util.List;
import java.util.logging.Logger;

public class Expense {
    private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final Money moneySpent;
    private final Person spentPerson;
    private final List<Person> personsInvolved;

    public Expense(Person spentPerson, Money moneySpent, List<Person> personsInvolved) {
        this.spentPerson = spentPerson;
        this.moneySpent = moneySpent;
        this.personsInvolved = personsInvolved;
    }

    public void split() {
        logger.info("Split is called in expense");
        Money splitAmount = moneySpent.divide(personsInvolved.size());
        for (Person eachPerson : personsInvolved) {
            logger.info("Subtract owed Money from the person");
            eachPerson.subtractOwedMoney(splitAmount);
        }
        logger.info("Add Money Spent to the spent person");
        spentPerson.addMoneySpent(moneySpent);
    }

}

