package org.eternity.billing.step02;

import org.eternity.money.Money;
import org.eternity.time.DateTimeInterval;

import java.time.Duration;

public class FeePerDuration {
    private Money fee;
    private Duration duration;

    public FeePerDuration(Money fee, Duration duration) {
        this.fee = fee;
        this.duration = duration;
    }

    public Money calculate(DateTimeInterval interval) {
        return fee.times(Math.ceil((double)interval.duration().toNanos() / duration.toNanos()));
    }
}

