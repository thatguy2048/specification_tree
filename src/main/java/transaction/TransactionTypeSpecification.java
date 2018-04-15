package transaction;

import specification.CompositeSpecification;

//Check if a transaction if of a specific type
public class TransactionTypeSpecification extends CompositeSpecification<Transaction> {
    TransactionType ttype;

    public TransactionTypeSpecification(TransactionType ttype) {
        this.ttype = ttype;
    }

    public boolean isSatisfiedBy(Transaction transaction) {
        return transaction.type == ttype;
    }
}
