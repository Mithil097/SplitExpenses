package model;

import java.util.List;
import java.util.logging.*;

public class GroupExpense {
    private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public void splitExpense(List<Expense> allExpenses) {
        for (Expense eachExpense : allExpenses) {
            logger.info("Iterate through each expense");
            eachExpense.split();
        }
    }
}
