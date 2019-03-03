package org.eternity.movie.step01.pricing;

import org.eternity.money.Money;
import org.eternity.movie.step01.DiscountPolicy;
import org.eternity.movie.step01.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
