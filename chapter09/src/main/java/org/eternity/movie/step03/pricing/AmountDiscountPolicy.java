package org.eternity.movie.step03.pricing;

import org.eternity.money.Money;
import org.eternity.movie.step03.DiscountCondition;
import org.eternity.movie.step03.DiscountPolicy;
import org.eternity.movie.step03.Screening;

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
