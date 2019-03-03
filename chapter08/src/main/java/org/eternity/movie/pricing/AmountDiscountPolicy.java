package org.eternity.movie.pricing;

import org.eternity.money.Money;
import org.eternity.movie.DiscountCondition;
import org.eternity.movie.DiscountPolicy;
import org.eternity.movie.Screening;

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
