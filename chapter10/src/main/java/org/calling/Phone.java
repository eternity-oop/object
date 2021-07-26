package org.calling;

import java.time.Duration;

public class Phone extends AbstractPhone {
    private Money amount;
    private Duration seconds;

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    @Override
    protected Money calculateCallFee(PhoneCall call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}