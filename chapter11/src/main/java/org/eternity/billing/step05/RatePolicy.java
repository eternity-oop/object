package org.eternity.billing.step05;

import org.eternity.money.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
