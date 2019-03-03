package org.eternity.movie;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
