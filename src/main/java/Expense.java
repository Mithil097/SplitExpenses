public class Expense {
    private final Money moneySpent;
    private final Person spentPerson;
    private final Person owedPerson;

    public Expense(Person spentPerson, Money moneySpent,Person person) {
        this.spentPerson=spentPerson;
        this.moneySpent=moneySpent;
        this.owedPerson=person;
    }

    public void split() {
        spentPerson.spent(moneySpent);
        owedPerson.owes(moneySpent);
    }

    public String Display() {
        return spentPerson.toString();
    }
}
