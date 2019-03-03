package org.eternity.billing;

import org.eternity.money.Money;

import java.util.List;

public abstract class AdditionalRatePolicy implements RatePolicy {
    private RatePolicy next;

    public AdditionalRatePolicy(RatePolicy next) {
        changeNext(next);
    }

    protected void changeNext(RatePolicy next) {
        this.next = next;
        // 불변식
        assert next != null;
    }

    @Override
    public Money calculateFee(List<Call> calls) {
        // 불변식
        assert next != null;
        // 사전조건
        assert calls != null;

        Money fee = next.calculateFee(calls);
        Money result = afterCalculated(fee);

        // 사후조건
        assert result.isGreaterThanOrEqual(Money.ZERO);
        // 불변식
        assert next != null;

        return result;
    }

    abstract protected Money afterCalculated(Money fee);
}
