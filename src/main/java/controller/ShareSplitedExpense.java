package controller;

import model.Money;
import model.Person;
import view.Display;

import java.util.ArrayList;
import java.util.List;

public class ShareSplitedExpense {
    private List<Person> personsInvolved;

    public ShareSplitedExpense(List<Person> personsInvolved) {
        this.personsInvolved=personsInvolved;
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
