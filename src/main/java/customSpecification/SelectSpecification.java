package customSpecification;

import specification.CompositeSpecification;
import specification.Specification;

//Performs either the left or the right is satisfied check, base on a selector
public class SelectSpecification<T> extends CompositeSpecification<T> {
    Specification<T> selector;
    Specification<T> left;
    Specification<T> right;

    public SelectSpecification(Specification<T> selector, Specification<T> left, Specification<T> right) {
        this.selector = selector;
        this.left = left;
        this.right = right;
    }

    public boolean isSatisfiedBy(T t) {
        return selector.isSatisfiedBy( t ) ? left.isSatisfiedBy( t ) : right.isSatisfiedBy( t );
    }
}
