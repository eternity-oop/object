package org.eternity.billing;

import org.eternity.money.Money;

import java.util.List;

public abstract class BasicRatePolicy implements RatePolicy {
	@Override
	public Money calculateFee(List<Call> calls) {
        // 사전조건
        assert calls != null;

		Money result = Money.ZERO;

		for(Call call : calls) {
			result.plus(calculateCallFee(call));
		}

        // 사후조건
        assert result.isGreaterThanOrEqual(Money.ZERO);

		return result;
	}
	
	protected abstract Money calculateCallFee(Call call);
}
