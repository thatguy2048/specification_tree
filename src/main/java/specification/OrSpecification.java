package specification;

public class OrSpecification<T> extends CompositeSpecification<T> {
    Specification<T> left;
    Specification<T> right;

    public OrSpecification(Specification<T> left, Specification<T> right) {
        this.left = left;
        this.right = right;
    }

    public boolean isSatisfiedBy(T t) {
        return left.isSatisfiedBy(t) || right.isSatisfiedBy(t);
    }
}
