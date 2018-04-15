package transaction;

import java.util.Date;
import java.util.Random;

public class TransactionFactory {
    static final long millisecondsInYear = 31556952000l;
    long millisecondsSinceEpoc;
    long minDateValue;
    long maxDateRange;

    ProductFactory productFactory;
    Random rando;

    public TransactionFactory(){
        rando = new Random();
        millisecondsSinceEpoc = System.currentTimeMillis();
        minDateValue = millisecondsSinceEpoc - (millisecondsInYear);
        maxDateRange = millisecondsSinceEpoc - minDateValue;

        productFactory = new ProductFactory();
    }

    Date generateDate(){
        return new Date(minDateValue + rando.nextLong() % maxDateRange );
    }

    TransactionType generateTransaction(){
        return TransactionType.values()[rando.nextInt(TransactionType.values().length)];
    }

    Product[] generateProducts(){
        int length = rando.nextInt(6);
        Product[] output = new Product[length];
        for( int i = 0; i < length; ++i ){
            output[i] = productFactory.generateRandomProdcut();
        }
        return output;
    }

    public Transaction generateRandomTransaction(){
        Transaction output = new Transaction();
        output.date = generateDate();
        output.type = generateTransaction();
        output.amount = rando.nextInt(55555);
        output.customer_id = rando.nextInt(1000000);
        output.products = generateProducts();
        return output;
    };
}
