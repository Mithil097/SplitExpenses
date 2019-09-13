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

    public boolean isOwed() {
        return effectiveMoney.getMoney() < 0.0;
    }

    public double getOwedMoney() {
        return -(effectiveMoney.getMoney());
    }

    public double getEffectiveMoney() {
        return this.effectiveMoney.getMoney();
    }
}

