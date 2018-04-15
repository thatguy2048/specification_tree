package specification;

public class NotSpecification<T> extends CompositeSpecification<T> {
    Specification<T> specification;

    public NotSpecification(Specification<T> specification) {
        this.specification = specification;
    }

    public boolean isSatisfiedBy(T t) {
        return !specification.isSatisfiedBy(t);
    }
}
