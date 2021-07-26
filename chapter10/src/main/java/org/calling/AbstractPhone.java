package org.calling;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPhone {
    private List<PhoneCall> calls = new ArrayList<>();

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (PhoneCall call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    protected abstract Money calculateCallFee(PhoneCall call);
}
