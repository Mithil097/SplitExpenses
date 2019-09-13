import controller.ShareSplitedExpense;
import model.Person;
import org.junit.jupiter.api.Test;
import view.Display;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ShareSplitedExpenseTest {
    @Test
    void expectEachPersonCheckedWhetherHeHadOwedSomething() {
        Person personA = mock(Person.class);
        Person personB = mock(Person.class);
        Person personC = mock(Person.class);
        Display display = mock(Display.class);
        ShareSplitedExpense share = new ShareSplitedExpense(Arrays.asList(personA, personB, personC), display);
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
        ShareSplitedExpense share = new ShareSplitedExpense(Arrays.asList(personA, personB), display);
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
        ShareSplitedExpense share = new ShareSplitedExpense(Arrays.asList(personA, personB, personC), display);
        share.shareAmongThemselves();
        verify(personA, times(2)).isOwed();
        verify(personB, times(2)).isOwed();
        verify(personC, times(2)).isOwed();
    }

    @Test
    void expectPersonBEffectiveMoneyGreaterThanPersonAOwedMoney() throws IOException {
        Person personA = mock(Person.class);
        Person personB = mock(Person.class);
        Person personC = mock(Person.class);
        when(personB.getEffectiveMoney()).thenReturn(20.0);
        when(personA.getOwedMoney()).thenReturn(15.0);
        Display display = new Display();
        ShareSplitedExpense share = new ShareSplitedExpense(Arrays.asList(personA, personB, personC), display);
        share.shareAmongThemselves();
        assertEquals(true, personB.getEffectiveMoney() > personA.getOwedMoney());
    }

}
