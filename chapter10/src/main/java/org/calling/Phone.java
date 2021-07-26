package org.calling;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone {
    private Money amount;
    private Duration seconds;
    private List<PhoneCall> calls = new ArrayList<>();

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    public void call(PhoneCall call) {
        calls.add(call);
    }

    public List<PhoneCall> getPhoneCalls() {
        return calls;
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (PhoneCall call : calls) {
            result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
        }

        return result;
    }
}