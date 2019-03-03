package org.eternity.movie.step02.pricing;

import org.eternity.money.Money;
import org.eternity.movie.step02.DiscountPolicy;
import org.eternity.movie.step02.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
