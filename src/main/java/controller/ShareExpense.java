package controller;

import model.Money;
import model.Person;
import view.Display;

import java.util.ArrayList;
import java.util.List;

public class ShareExpense {
    private final Display display;
    private List<Person> personsInvolved;

    public ShareExpense(List<Person> personsInvolved, Display display) {
        this.personsInvolved = personsInvolved;
        this.display = display;
    }

    public void share() {
        List<Person> owesPersons = getOwesPersons();
        for (Person owesPerson : owesPersons) {
            for (Person person : personsInvolved) {
                if (person.isOwed()) {
                    if (owesPerson.getEffectiveMoney() >= person.getOwedMoney()) {
                        display.displayOwesPersonGetCompleteMoney(person, owesPerson);
                        owesPerson.subtractOwedMoney(new Money(person.getOwedMoney()));
                        person.addMoneySpent(new Money(person.getOwedMoney()));
                    }
                    if (owesPerson.getEffectiveMoney()<person.getOwedMoney() && owesPerson.getEffectiveMoney()>0.0){
                        display.displayOwedPersonGiveCompleteMoney(person,owesPerson);
                        person.addMoneySpent(new Money(owesPerson.getEffectiveMoney()));
                        owesPerson.subtractOwedMoney(new Money(owesPerson.getEffectiveMoney()));
                    }
                }
            }
        }
    }

    public List<Person> getOwesPersons() {
        List<Person> owesPersons = new ArrayList<>();
        for (Person person : personsInvolved) {
            if (!person.isOwed()) {
                owesPersons.add(person);
            }
        }
        return owesPersons;
    }

}
