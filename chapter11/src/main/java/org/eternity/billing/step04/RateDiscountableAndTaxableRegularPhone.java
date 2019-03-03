package org.eternity.billing.step04;

import org.eternity.money.Money;

import java.time.Duration;

public class RateDiscountableAndTaxableRegularPhone
        extends RateDiscountableRegularPhone {
    private double taxRate;

    public RateDiscountableAndTaxableRegularPhone(Money amount, Duration seconds, Money discountAmount, double taxRate) {
        super(amount, seconds, discountAmount);
        this.taxRate = taxRate;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return super.afterCalculated(fee).plus(fee.times(taxRate));
    }
}
