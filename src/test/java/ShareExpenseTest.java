import controller.ShareExpense;
import model.Person;
import org.junit.jupiter.api.Test;
import view.Display;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class ShareExpenseTest {
    @Test
    void expectEachPersonCheckedWhetherHeHadOwedSomething() {
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
        when(personA.isOwed()).thenReturn(true);
        when(personB.isOwed()).thenReturn(false);
        ShareExpense share = new ShareExpense(Arrays.asList(personA, personB), display);
        List<Person> owesPersons = share.getOwesPersons();
        assertEquals(1, owesPersons.size());
    }

    @Test
    void expectIsOwedCalled2TimesWhenPersonAAndPersonCOwesFromPersonB() {
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
    void expectPersonBEffectiveMoneyGreaterThanPersonAOwedMoney() {
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
    void expectPersonBEffectiveMoneyEqualToPersonAOwedMoney() {
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
    void expectPersonBEffectiveMoneyLessThanPersonAOwedMoney() {
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

}
