package org.eternity.movie.step03.pricing;

import org.eternity.money.Money;
import org.eternity.movie.step03.DiscountPolicy;
import org.eternity.movie.step03.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
