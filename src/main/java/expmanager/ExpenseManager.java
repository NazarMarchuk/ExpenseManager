package expmanager;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class ExpenseManager {
    private final Map<String, List<Expense>> expenses = new TreeMap<>();
    private final CurrencyConverter currencyConverter = new CurrencyConverter();

    //add new expense to list and print all the expenses grouped by date
    public void addExpense(Expense newExpense){
        List<Expense> expensesForCurrentDate;

        if (expenses.containsKey(newExpense.getDate())){
            expensesForCurrentDate = expenses.get(newExpense.getDate());
        }else
            expensesForCurrentDate = new ArrayList<>();

        expensesForCurrentDate.add(newExpense);
        this.expenses.put(newExpense.getDate(), expensesForCurrentDate);
        this.printAllExpenses();
    }

    //print all expenses grouped by date
    public void printAllExpenses(){
        for(Map.Entry<String, List<Expense>> entry : expenses.entrySet()){
            System.out.println(entry.getKey());
            for(Expense e : entry.getValue()){
                System.out.println(e.getName() + " " + e.getAmount() + " " + e.getCurrency());
            }
            System.out.println();
        }
    }

    //remove all expenses with chosen date
    public void removeExpenseByDate(String date){
        expenses.remove(date);
        this.printAllExpenses();
    }

    //print total of all expenses converted to chosen currency
    public void printTotal(String currency){
        BigDecimal total = new BigDecimal(BigInteger.ZERO);
        for(Map.Entry<String, List<Expense>> entry : expenses.entrySet()){
            for(Expense e : entry.getValue()){
                total = total.add(new BigDecimal(currencyConverter.getAmountConverted(e.getCurrency(), currency, String.valueOf(e.getAmount()))));
            }
        }
        String stringTotal = String.format("%.2f", total);
        System.out.println("Total: " + stringTotal + " " + currency);
    }


}
