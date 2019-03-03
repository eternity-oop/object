package org.eternity.movie.step01.pricing;

import org.eternity.movie.step01.DiscountCondition;
import org.eternity.movie.step01.Screening;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
