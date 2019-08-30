public class Expense {
    private final Money moneySpent;
    private final Person spentPerson;

    public Expense(Person spentPerson, Money moneySpent) {
        this.spentPerson=spentPerson;
        this.moneySpent=moneySpent;
    }

    public void split() {
        spentPerson.spent(moneySpent);
        spentPerson.owes(moneySpent);
    }

    public String Display() {
        return spentPerson.toString();
    }
}
