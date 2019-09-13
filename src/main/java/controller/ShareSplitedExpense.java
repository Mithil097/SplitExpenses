package controller;

import model.Money;
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
                    if (owesPerson.getEffectiveMoney()>=person.getOwedMoney()){
                        display.displayOwesPersonGetCompleteMoney(person,owesPerson);
                        owesPerson.subtractOwedMoney(new Money(person.getOwedMoney()));
                        person.addMoneySpent(new Money(person.getOwedMoney()));
                    }
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
