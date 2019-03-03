package org.eternity.movie.pricing;

import org.eternity.movie.DiscountCondition;
import org.eternity.movie.DiscountPolicy;
import org.eternity.movie.Screening;
import org.eternity.money.Money;

import java.util.List;

public class NoneDiscountPolicy implements DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return screening.getMovieFee();
    }

    @Override
    public List<DiscountCondition> getConditions() {
        return null;
    }

    @Override
    public Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
