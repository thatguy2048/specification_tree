package transaction;

import customSpecification.DateCompareSpecification;
import specification.CompositeSpecification;
import specification.Specification;

import java.util.Date;

//Check if a transaction has occured after a provided date
public class TransactionDateSpecification extends CompositeSpecification<Transaction> {
    Date date;
    Specification<Date> greatDateCheck;

    public TransactionDateSpecification(Date date) {
        this.date = date;
        greatDateCheck = new DateCompareSpecification(date).not();
    }

    public boolean isSatisfiedBy(Transaction transaction) {
        return greatDateCheck.isSatisfiedBy( transaction.date );
    }
}
