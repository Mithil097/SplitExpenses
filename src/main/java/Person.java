public class Person {

    final String personName;
    private final Money effectiveMoney;

    public Person(String personName) {
        this.personName = personName;
        this.effectiveMoney = new Money(0.0);
    }

    void addMoneySpent(Money moneySpent) {
        effectiveMoney.add(moneySpent);
    }

    void owedMoney(Money owedMoney) {
        effectiveMoney.subtract(owedMoney);
    }

    double getEffectiveMoney() {
        return this.effectiveMoney.getMoney();
    }

    @Override
    public String toString() {
        return personName + effectiveMoney;
    }
}

