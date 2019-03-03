package org.eternity.movie.pricing;

import org.eternity.money.Money;
import org.eternity.movie.DiscountCondition;
import org.eternity.movie.DiscountPolicy;
import org.eternity.movie.Screening;

public class PercentDiscountPolicy extends DiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
