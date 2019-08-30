public class Person {

    private final String personName;
    private final Money myMoney;

    public Person(String personName) {
        this.personName = personName;
        this.myMoney=new Money(0.0);
    }

    void spent(Money moneySpent) {
        myMoney.add(moneySpent);
    }

    void owes(Money moneySpent) {
        myMoney.subtract(moneySpent);
    }

    @Override
    public String toString() {
        return personName + " has " + myMoney ;
    }
}
