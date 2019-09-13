package view;

import model.Person;

public class Display {
    public void printOwesPersonShare(Person owedPerson, Person owesPerson) {
        System.out.println(owedPerson.personName + " --> " + owesPerson.personName + " " + owedPerson.getOwedMoney());
    }

    public void printOwedPersonShare(Person owedPerson, Person owesPerson) {
        System.out.println(owedPerson.personName + " --> " + owesPerson.personName + " " +owesPerson.getEffectiveMoney());
    }
}
