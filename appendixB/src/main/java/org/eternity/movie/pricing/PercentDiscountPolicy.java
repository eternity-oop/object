package org.eternity.movie.pricing;

import org.eternity.movie.DiscountCondition;
import org.eternity.movie.DiscountPolicy;
import org.eternity.movie.Screening;
import org.eternity.money.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PercentDiscountPolicy implements DiscountPolicy {
    private double percent;
    private List<DiscountCondition> conditions = new ArrayList<>();

    public PercentDiscountPolicy(double percent,
                                 DiscountCondition... conditions) {
        this.percent = percent;
        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public List<DiscountCondition> getConditions() {
        return conditions;
    }

    @Override
    public Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
