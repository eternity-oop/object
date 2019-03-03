package org.eternity.billing.step02;

import org.eternity.money.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
