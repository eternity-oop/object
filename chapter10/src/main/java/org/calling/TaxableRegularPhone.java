package org.calling;

import java.time.Duration;

//super() of RegularPhone() 단일상속, Phone 무관
public class TaxableRegularPhone extends RegularPhone {

    private final double taxRate;

    public TaxableRegularPhone(Money amount, Duration seconds, double taxRate) {
        super(amount, seconds);
        this.taxRate = taxRate;
    }
}
