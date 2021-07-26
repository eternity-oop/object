package org.calling;

import java.time.Duration;

public class RegularPolicy extends BasicRatePolicy {
    private final Money amount;
    private final Duration seconds;

    //abstract class no 생성자, no super()
    public RegularPolicy(Money amount, Duration seconds) {
        this.amount  = amount;
        this.seconds = seconds;
    }

    //RegularPhone의 calculateCallFee() 코드 차용
    @Override
    protected Money calculateCallFee(PhoneCall call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
