package expmanager;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Expense{
    private String date;
    private BigDecimal amount;
    private String currency;
    private String name;

    public Expense(String date, String amount, String currency, String name) {
        this.date = date;
        this.amount = new BigDecimal(amount);
        this.currency = currency;
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = new BigDecimal(amount);
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
