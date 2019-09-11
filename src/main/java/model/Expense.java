package model;

import java.util.List;
import java.util.logging.Logger;

public class Expense {
    private final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final Money moneySpent;
    private final Person spentPerson;
    private final List<Person> personsInvolved;

    public Expense(Person spentPerson, Money moneySpent, List<Person> personsInvolved) {
        this.spentPerson = spentPerson;
        this.moneySpent = moneySpent;
        this.personsInvolved = personsInvolved;
    }

    public void split() {
        log.info("Split is called in expense");
        Money splitAmount = moneySpent.divide(personsInvolved.size());
        for (Person eachPerson : personsInvolved) {
            eachPerson.subtractOwedMoney(splitAmount);
        }
        spentPerson.addMoneySpent(moneySpent);
    }

}

