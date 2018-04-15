package specification;

public abstract class CompositeSpecification<T> implements  Specification<T> {
    public Specification<T> and(Specification<T> other) {
        return new AndSpecification<T>( this, other );
    }

    public Specification<T> or(Specification<T> other) {
        return new OrSpecification<T>( this, other );
    }

    public Specification<T> not() {
        return new NotSpecification<T>( this );
    }

    public Specification<T> xor(Specification<T> other) {
        return new XorSpecification<T>( this, other );
    }
}
