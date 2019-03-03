package org.eternity.movie.step02;

import org.eternity.money.Money;

import java.time.Duration;
import java.time.LocalDateTime;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        if (screening == null ||
                screening.getStartTime().isBefore(LocalDateTime.now())) {
            throw new InvalidScreeningException();
        }

        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public LocalDateTime getEndTimeFrom(LocalDateTime whenStarted) {
        return whenStarted.plus(runningTime);
    }
}

