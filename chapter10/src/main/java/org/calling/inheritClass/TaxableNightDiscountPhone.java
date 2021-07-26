package org.calling.inheritClass;

import org.calling.Money;

import java.time.Duration;
//super() of NightDiscountPhone() 단일상속, Phone 무관
public class TaxableNightDiscountPhone extends NightDiscountPhone {
    private final double taxRate;

    public TaxableNightDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
        super(nightlyAmount, regularAmount, seconds);
        this.taxRate = taxRate;
    }
}
