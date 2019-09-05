public class Person {

    private final String personName;
    private final Money myMoney;

    public Person(String personName) {
        this.personName = personName;
        this.myMoney = new Money(0.0);
    }

    void addMoneySpentByMe(Money moneySpentByMe) {
        myMoney.add(moneySpentByMe);
    }

    void owesMoneySpentOnMe(Money moneySpentToMe) {
        myMoney.subtract(moneySpentToMe);
    }

    @Override
    public String toString() {
        return personName + " gets " + myMoney;
    }
}
