import customSpecification.DateCompareSpecification;
import specification.AndSpecification;
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


        //Date creator
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        //Product representative specification
        ProductNameSpecification productSpec = new ProductNameSpecification("flamethrower");

        //Product representative specification
        Specification<Transaction> PRSpec = productSpec.and(
                new TransactionDateSpecification(sdf.parse("01/01/2018")))
                .and(new NotSpecification<Transaction>(new TransactionTypeSpecification(TransactionType.OTHER)));

        //Quality Assurance Specification
        CompositeSpecification<Transaction> QASpec = new AndSpecification<Transaction>(
                new TransactionDateSpecification(sdf.parse("01/03/2018")),
                new TransactionTypeSpecification((TransactionType.RETURN))
        );

        do{
            currentTransaction = transactionFactory.generateRandomTransaction();
            System.out.println(currentTransaction);

            if( PRSpec.isSatisfiedBy(currentTransaction) ){
                System.out.println("Show PR Transaction");
            }

            if( QASpec.isSatisfiedBy(currentTransaction) ){
                System.out.println("Show QA Transaction");
            }

        }while(!reader.nextLine().contains("exit"));

        reader.close();
        System.out.println( "DONE" );
    }
}
