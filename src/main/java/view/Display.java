package view;

import model.Person;

import java.util.List;

public class Display {
    public void displayOwesPersonGetCompleteMoney(Person personA, Person personB) {
        System.out.println(personA.personName + " --> " + personB.personName + " " +personA.owedMoney());
    }

    public void displayOwedPersonGiveCompleteMoney(Person personA, Person personB) {
        System.out.println(personA.personName + " --> " + personB.personName + " " +personB.getEffectiveMoney());
    }
}
