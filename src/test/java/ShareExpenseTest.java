import controller.ShareExpense;
import model.Money;
import model.Person;
import org.junit.jupiter.api.Test;
import view.Display;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShareExpenseTest {
    @Test
    void expectIsOwedCalledForAllPersonsInvolvedInExpense() {
        Person personA = mock(Person.class);
        Person personB = mock(Person.class);
        Person personC = mock(Person.class);
        Display display = mock(Display.class);
        ShareExpense share = new ShareExpense(Arrays.asList(personA, personB, personC), display);
        share.getOwesPersons();
        verify(personA, times(1)).isOwed();
        verify(personB, times(1)).isOwed();
        verify(personC, times(1)).isOwed();

    }

    @Test
    void expectListOfPersonsOwesSizeIs1WhenPersonAOwesFromPersonB() {
        Person personA = mock(Person.class);
        Person personB = mock(Person.class);
        Display display = mock(Display.class);
        Money money=mock(Money.class);
        personB.addMoneySpent(money);
        personA.subtractOwedMoney(money);
        when(personA.isOwed()).thenReturn(true);
        when(personB.isOwed()).thenReturn(false);
        ShareExpense share = new ShareExpense(Arrays.asList(personA, personB), display);
        List<Person> owesPersons = share.getOwesPersons();
        assertEquals(1, owesPersons.size());
    }

    @Test
    void expectIsOwedCalled2TimesWhenPersonAAndPersonCOwedAndPersonBIsNotOwed() {
        Person personA = mock(Person.class);
        Person personB = mock(Person.class);
        Person personC = mock(Person.class);
        when(personA.isOwed()).thenReturn(true);
        when(personB.isOwed()).thenReturn(false);
        when(personC.isOwed()).thenReturn(true);
        Display display = new Display();
        ShareExpense share = new ShareExpense(Arrays.asList(personA, personB, personC), display);
        share.share();
        verify(personA, times(2)).isOwed();
        verify(personB, times(2)).isOwed();
        verify(personC, times(2)).isOwed();
    }

    @Test
    void expectTrueWhenPersonBEffectiveMoneyGreaterThanPersonAOwedMoney() {
        Person personA = mock(Person.class);
        Person personB = mock(Person.class);
        Person personC = mock(Person.class);
        when(personB.getEffectiveMoney()).thenReturn(20.0);
        when(personA.getOwedMoney()).thenReturn(15.0);
        Display display = new Display();
        ShareExpense share = new ShareExpense(Arrays.asList(personA, personB, personC), display);
        share.share();
        assertTrue(personB.getEffectiveMoney() > personA.getOwedMoney());
    }

    @Test
    void expectTrueWhenPersonBEffectiveMoneyEqualToPersonAOwedMoney() {
        Person personA = mock(Person.class);
        Person personB = mock(Person.class);
        Person personC = mock(Person.class);
        when(personB.getEffectiveMoney()).thenReturn(30.0);
        when(personA.getOwedMoney()).thenReturn(30.0);
        Display display = new Display();
        ShareExpense share = new ShareExpense(Arrays.asList(personA, personB, personC), display);
        share.share();
        assertTrue(personB.getEffectiveMoney() == personA.getOwedMoney());
    }

    @Test
    void expectTrueWhenPersonBEffectiveMoneyLessThanPersonAOwedMoney() {
        Person personA = mock(Person.class);
        Person personB = mock(Person.class);
        Person personC = mock(Person.class);
        when(personB.getEffectiveMoney()).thenReturn(30.0);
        when(personA.getOwedMoney()).thenReturn(35.0);
        Display display = new Display();
        ShareExpense share = new ShareExpense(Arrays.asList(personA, personB, personC), display);
        share.share();
        assertTrue(personB.getEffectiveMoney() < personA.getOwedMoney());
    }

    @Test
    void expectFalseWhenPersonBEffectiveMoneyISZero() {
        Person personA = mock(Person.class);
        Person personB = mock(Person.class);
        Person personC = mock(Person.class);
        when(personB.getEffectiveMoney()).thenReturn(0.0);
        when(personA.getOwedMoney()).thenReturn(30.0);
        Display display = new Display();
        ShareExpense share = new ShareExpense(Arrays.asList(personA, personB, personC), display);
        share.share();
        assertFalse(personB.getEffectiveMoney() < personA.getOwedMoney() && personB.getEffectiveMoney() > 0.0);
    }

}
