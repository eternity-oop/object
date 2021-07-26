package org.calling;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NightPhone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;
    private List<PhoneCall> calls = new ArrayList<>();

    public NightPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for(PhoneCall call : calls) {
                result = result.plus(calculateCallFee(call));
        }
        return result;
    }

    private Money calculateCallFee(PhoneCall call){
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        } else {
            return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        }
    }
}