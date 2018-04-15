import customSpecification.DateCompareSpecification;
import specification.CompositeSpecification;
import specification.NotSpecification;
import specification.Specification;
import transaction.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main( String[] args ) throws ParseException {
        Scanner reader = new Scanner(System.in);
        TransactionFactory transactionFactory = new TransactionFactory();
        Transaction currentTransaction;


        //Get the date at the start of the year.
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date thisYear = sdf.parse("01/01/2018");

        //Product representative specification
        ProductNameSpecification productSpec = new ProductNameSpecification("flamethrower");

        //Product representative specification
        Specification<Transaction> PRSpec = productSpec.and(
                new TransactionDateSpecification(thisYear))
                .and(new NotSpecification<Transaction>(new TransactionTypeSpecification(TransactionType.OTHER)));

        do{
            currentTransaction = transactionFactory.generateRandomTransaction();
            System.out.println(currentTransaction);

            if( PRSpec.isSatisfiedBy(currentTransaction) ){
                System.out.println("Show Transaction");
            }

        }while(!reader.nextLine().contains("exit"));

        reader.close();
        System.out.println( "DONE" );
    }
}
