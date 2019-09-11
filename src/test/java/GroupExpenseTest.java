import model.Expense;
import model.GroupExpense;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GroupExpenseTest {
    @Test
    void expectSplitIsCalledForEachExpenseWhenSplitExpenseIsCalledInGroupExpense() {
        Expense expense1 = mock(Expense.class);
        Expense expense2 = mock(Expense.class);
        Expense expense3 = mock(Expense.class);
        GroupExpense trip = new GroupExpense();
        trip.splitExpense(Arrays.asList(expense1, expense2, expense3));
        verify(expense1).split();
        verify(expense2).split();
        verify(expense3).split();
    }
}