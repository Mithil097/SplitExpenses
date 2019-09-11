import model.Expense;
import model.Money;
import model.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ExpenseTest {
    @Test
    void expectMoneyDividedWhenSplitCalledInExpense() {
        Person person = mock(Person.class);
        Money money = mock(Money.class);
        Expense expense = new Expense(person, money, Arrays.asList(person));
        expense.split();
        verify(money).divide(anyInt());
    }

    @Test
    void expectAddMoneySpentCalledWhenSplitCalledInExpense() {
        Person person = mock(Person.class);
        Money money = mock(Money.class);
        Expense expense = new Expense(person, money, Arrays.asList(person));
        expense.split();
        verify(person).addMoneySpent(money);
    }

    @Test
    void expectPersonBCalledSubtractOwedMoneyWhenPersonASpentOnPersonB() {
        Person personA = mock(Person.class);
        Person personB = mock(Person.class);
        Money money = mock(Money.class);
        Expense expense = new Expense(personA, money, Arrays.asList(personB));
        expense.split();
        verify(personB).subtractOwedMoney(any());
    }

    @Test
    void expectPersonAAndPersonBCalledSubtractOwedMoneyWhenPersonASpentMoneyOnHimAndPersonB() {
        Person personA = mock(Person.class);
        Person personB = mock(Person.class);
        Money money = mock(Money.class);
        Expense expense = new Expense(personA, money, Arrays.asList(personA, personB));
        expense.split();
        verify(personA).subtractOwedMoney(any());
        verify(personB).subtractOwedMoney(any());
    }
}

