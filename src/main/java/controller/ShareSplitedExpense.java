package controller;

import model.Person;
import view.Display;

import java.util.ArrayList;
import java.util.List;

public class ShareSplitedExpense {
    private final Display display;
    private List<Person> personsInvolved;


    public ShareSplitedExpense(List<Person> personsInvolved, Display display) {
        this.personsInvolved=personsInvolved;
        this.display= display;
    }

    public void shareAmongThemselves(){
        List<Person> owesPersons=getOwesPersons();
        for (Person owesPerson : owesPersons) {
            for (Person person:personsInvolved){
                if (person.isOwed()) {
                    display.displayOwedPersonGiveCompleteMoney(owesPerson,person);
                }
            }
        }
    }

    public List<Person> getOwesPersons(){
        List<Person> owesPersons=new ArrayList<>();
        for (Person person:personsInvolved){
            if (!person.isOwed()){
                owesPersons.add(person);
            }
        }
        return owesPersons;
    }

}
