package expmanager;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running){
            String action = scanner.nextLine();

            if(action.equals("stop"))
                running=false;

            parseAction(expenseManager, action);
        }


    }

    private static void parseAction(ExpenseManager expenseManager, String action){

        String[] actionList = action.split(" ");
        if (actionList.length==0) return;
        switch (actionList[0]) {
            case ("add") ->
                    expenseManager.addExpense(new Expense(actionList[1], actionList[2], actionList[3], actionList[4]));
            case ("list") -> expenseManager.printAllExpenses();
            case ("clear") -> expenseManager.removeExpenseByDate(actionList[1]);
            case ("total") -> expenseManager.printTotal(actionList[1]);
        }
    }


}
