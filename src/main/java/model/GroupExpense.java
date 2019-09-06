package model;

import java.util.List;

public class GroupExpense {
    public void splitExpense(List<Expense> allExpenses) {
        for (Expense eachExpense : allExpenses) {
            eachExpense.split();
        }
    }
}
