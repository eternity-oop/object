package org.eternity.billing.step04;

import org.eternity.money.Money;

import java.time.Duration;

public class RateDiscountableRegularPhone extends RegularPhone {
    private Money discountAmount;

    public RateDiscountableRegularPhone(Money amount, Duration seconds, Money discountAmount) {
        super(amount, seconds);
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
