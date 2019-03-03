package org.eternity.billing.step01;

import org.eternity.money.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
