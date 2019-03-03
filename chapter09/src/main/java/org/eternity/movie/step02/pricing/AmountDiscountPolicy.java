package org.eternity.movie.step02.pricing;

import org.eternity.money.Money;
import org.eternity.movie.step02.DiscountCondition;
import org.eternity.movie.step02.DiscountPolicy;
import org.eternity.movie.step02.Screening;

public class AmountDiscountPolicy extends DiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
