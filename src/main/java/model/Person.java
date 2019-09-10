package model;

public class Person {

    public final String personName;
    private final Money effectiveMoney;

    public Person(String personName) {
        this.personName = personName;
        this.effectiveMoney = new Money(0.0);
    }

    public void addMoneySpent(Money moneySpent) {
        effectiveMoney.add(moneySpent);
    }

    public void subtractOwedMoney(Money owedMoney) {
        effectiveMoney.subtract(owedMoney);
    }

    public double getEffectiveMoney() {
        return this.effectiveMoney.getMoney();
    }
}

