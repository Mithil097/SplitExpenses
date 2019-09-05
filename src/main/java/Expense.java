import java.util.List;

class Expense {
    private final Money moneySpent;
    private final Person spentPerson;
    private final List<Person> persons;

    public Expense(Person spentPerson, Money moneySpent, List<Person> persons) {
        this.spentPerson = spentPerson;
        this.moneySpent = moneySpent;
        this.persons = persons;
    }

    public void split() {
        Money splitAmount = moneySpent.divide(persons.size());
        for (Person eachPerson : persons) {
            eachPerson.owesMoneySpentOnMe(splitAmount);
        }
        spentPerson.addMoneySpentByMe(moneySpent);
    }

    public String Display() {

        return spentPerson.toString();
    }
}
