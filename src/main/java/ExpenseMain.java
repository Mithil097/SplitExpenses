import controller.Expense;
import model.Money;
import model.Person;

import java.util.Arrays;

public class ExpenseMain {
    public static void main(String[] args) {
        {
            Person person1 = new Person("person1");
            Person person2 = new Person("person2");
            Person person3 = new Person("person3");
            Money moneySpent=new Money(90.0);
            Expense expense = new Expense(person1, moneySpent, Arrays.asList(person1,person2,person3));
            expense.split();
            System.out.println(expense.display());
        }
    }
}
