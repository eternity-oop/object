package org.eternity.movie.step02.factory;

import org.eternity.money.Money;
import org.eternity.movie.step01.Movie;
import org.eternity.movie.step01.pricing.AmountDiscountPolicy;
import org.eternity.movie.step01.pricing.SequenceCondition;

import java.time.Duration;

public class Factory {
    public Movie createAvatarMovie() {
        return new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(
                    Money.wons(800),
                    new SequenceCondition(1),
                    new SequenceCondition(10)));
    }
}
