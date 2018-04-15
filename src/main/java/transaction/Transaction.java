package transaction;

import java.util.Arrays;
import java.util.Date;

public class Transaction {
    public Date date;
    public TransactionType type;
    public int amount;
    public int customer_id;
    public Product[] products;

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", type=" + type +
                ", amount=" + amount +
                ", customer_id=" + customer_id +
                ", products=" + (products == null ? null : Arrays.asList(products)) +
                '}';
    }
}
