package org.eternity.movie.step01.pricing;

import org.eternity.movie.step01.DiscountPolicy;
import org.eternity.movie.step01.Screening;
import org.eternity.money.Money;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
