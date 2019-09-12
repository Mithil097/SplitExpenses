import controller.ShareSplitedExpense;
import model.Person;
import org.junit.jupiter.api.Test;
import view.Display;

import java.util.Arrays;

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
}
