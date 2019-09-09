import model.Expense;
import model.Money;
import model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpenseMain {
    public static void main(String[] args) {
        {
            Person person1 = new Person("person1");
            Person person2 = new Person("person2");
            Person person3 = new Person("person3");
            Money moneySpent = new Money(90.0);
            List<Person> personsInvolved=new ArrayList<>();
            personsInvolved.add(person1);
            personsInvolved.add(person2);
            personsInvolved.add(person3);
            Expense expense = new Expense(person1, moneySpent, Arrays.asList(person1, person2, person3));
            expense.split();
            for (Person person:personsInvolved){
                String personDetails="";
                if (person.getEffectiveMoney()<0.0){
                    personDetails +=person.personName+" has to give "+(-person.getEffectiveMoney());
                }
                else{
                    personDetails +=person.personName+" will get "+(person.getEffectiveMoney());
                }
                System.out.println(personDetails);
            }
        }
    }
}