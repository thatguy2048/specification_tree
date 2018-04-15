package customSpecification;

import specification.CompositeSpecification;

import java.util.Date;

//Check if date is less than a provided date.
public class DateCompareSpecification extends CompositeSpecification<Date> {
    Date checkDate;

    public DateCompareSpecification(Date checkDate) {
        this.checkDate = checkDate;
    }

    public boolean isSatisfiedBy(Date date) {
        return checkDate.compareTo(date) > 0;
    }
}
