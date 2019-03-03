package org.eternity.movie.step01;

import org.eternity.money.Money;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        checkPrecondition(screening);

        Money amount = Money.ZERO;
        for(DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                amount = getDiscountAmount(screening);
                checkPostcondition(amount);
                return amount;
            }
        }

        amount = screening.getMovieFee();
        checkPostcondition(amount);
        return amount;
    }

    protected void checkPrecondition(Screening screening) {
        assert screening != null &&
                screening.getStartTime().isAfter(LocalDateTime.now());
    }

    protected void checkPostcondition(Money amount) {
        assert amount != null && amount.isGreaterThanOrEqual(Money.ZERO);
    }


    abstract protected Money getDiscountAmount(Screening Screening);
}
