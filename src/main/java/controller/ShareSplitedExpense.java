package controller;

import model.Money;
import model.Person;

import java.util.ArrayList;
import java.util.List;

public class ShareSplitedExpense {
    private List<Person> personsInvolved;

    public ShareSplitedExpense(List<Person> personsInvolved) {
        this.personsInvolved=personsInvolved;
    }

    public void shareAmongThemselves(){
        List<Person> owesPersons=getOwesPersons();
        for (Person owesPerson : owesPersons) {
            for (Person person:personsInvolved){
                if (person.isOwed()) {
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
