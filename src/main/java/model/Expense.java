package model;

import java.util.List;

public class Expense {
    private final Money moneySpent;
    private final Person spentPerson;
    private final List<Person> personsInvolved;

    public Expense(Person spentPerson, Money moneySpent, List<Person> personsInvolved) {
        this.spentPerson = spentPerson;
        this.moneySpent = moneySpent;
        this.personsInvolved = personsInvolved;
    }

    public void split() {
        Money splitAmount = moneySpent.divide(personsInvolved.size());
        for (Person eachPerson : personsInvolved) {
            eachPerson.owedMoney(splitAmount);
        }
        spentPerson.addMoneySpent(moneySpent);
    }

}

