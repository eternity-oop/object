package org.eternity.billing;

import org.eternity.money.Money;

import java.util.List;

public interface RatePolicy {
	Money calculateFee(List<Call> calls);
}
