package view;

import model.Person;

public class Display {
    public void displayOwesPersonGetCompleteMoney(Person owedPerson, Person owesPerson) {
        System.out.println(owedPerson.personName + " --> " + owesPerson.personName + " " + owedPerson.getOwedMoney());
    }
}
