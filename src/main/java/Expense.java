import java.util.List;

public class Expense {
    private final Money moneySpent;
    private final Person spentPerson;
    private final List<Person> persons;

    public Expense(Person spentPerson, Money moneySpent, List<Person> persons) {
        this.spentPerson = spentPerson;
        this.moneySpent = moneySpent;
        this.persons = persons;
    }

    public void split() {
        Money splitAmount = moneySpent.share(persons.size());
        for (Person eachPerson : persons) {
            eachPerson.owes(splitAmount);
        }
        spentPerson.spent(moneySpent);
    }

    public String Display() {
        return spentPerson.toString();
    }
}
