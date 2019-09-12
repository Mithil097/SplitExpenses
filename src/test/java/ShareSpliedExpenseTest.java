import controller.ShareSplitedExpense;
import model.Money;
import model.Person;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.reflection.FieldSetter;
import view.Display;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ShareSpliedExpenseTest {
    @Test
    void expectEachPersonCheckedWhetherHeHadOwedSomething(){
        Person personA=mock(Person.class);
        Person personB=mock(Person.class);
        Person personC=mock(Person.class);
        ShareSplitedExpense share=new ShareSplitedExpense(Arrays.asList(personA,personB,personC));
        share.getOwesPersons();
        verify(personA,times(1)).isOwed();
        verify(personB,times(1)).isOwed();
        verify(personC,times(1)).isOwed();

    }
    @Test
    void expectEachPersonChecked3timesWhetherHeHadOwedSomething() throws NoSuchFieldException {
        Person personA = mock(Person.class);
        Person personB = mock(Person.class);
        Money money = mock(Money.class);
        personA.subtractOwedMoney(money);
        personB.addMoneySpent(money);
        ShareSplitedExpense share = new ShareSplitedExpense(Arrays.asList(personA, personB));
        List<Person> persons = share.getOwesPersons();
        when(personA.isOwed()).thenReturn(true);
        when(personB.isOwed()).thenReturn(false);
        assertEquals(1, persons.size());

    }
}
