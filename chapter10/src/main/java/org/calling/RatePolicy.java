package org.calling;

public interface RatePolicy {
    Money calculateFee(AnyPhone anyPhone);
}
