package transaction;

import specification.CompositeSpecification;

public class ProductNameSpecification extends CompositeSpecification<Transaction> {
    String nameToCheck;

    public ProductNameSpecification(String nameToCheck) {
        this.nameToCheck = nameToCheck;
    }

    public boolean isSatisfiedBy(Transaction transaction) {
        for( Product p : transaction.products){
            if( p.name.contains(nameToCheck) ) return true;
        }
        return false;
    }
}
