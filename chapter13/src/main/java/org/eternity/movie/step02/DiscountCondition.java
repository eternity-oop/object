package org.eternity.movie.step02;

import org.eternity.movie.step02.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
