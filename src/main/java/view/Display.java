package view;

import model.Person;

import java.util.List;

public class Display {
    public void display(List<Person> personsInvolved) {
        for (Person person : personsInvolved) {
            String personDetails = "";
            if (person.getEffectiveMoney() < 0.0) {
                personDetails += person.personName + " has to give " + (-person.getEffectiveMoney());
            } else {
                personDetails += person.personName + " will get " + (person.getEffectiveMoney());
            }
            System.out.println(personDetails);
        }
    }
}
