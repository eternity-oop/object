package org.eternity.movie.step02;

import org.eternity.money.Money;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Movie(String title, Duration runningTime, Money fee, double discountPercent, DiscountCondition... discountConditions) {
        this(MovieType.PERCENT_DISCOUNT, title, runningTime, fee, Money.ZERO, discountPercent, discountConditions);
    }

    public Movie(String title, Duration runningTime, Money fee, Money discountAmount, DiscountCondition... discountConditions) {
        this(MovieType.AMOUNT_DISCOUNT, title, runningTime, fee, discountAmount, 0, discountConditions);
    }

    public Movie(String title, Duration runningTime, Money fee) {
        this(MovieType.NONE_DISCOUNT, title, runningTime, fee, Money.ZERO, 0);
    }

    private Movie(MovieType movieType, String title, Duration runningTime, Money fee, Money discountAmount, double discountPercent,
                  DiscountCondition... discountConditions) {
        this.movieType = movieType;
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountAmount = discountAmount;
        this.discountPercent = discountPercent;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public Money calculateAmountDiscountedFee() {
        if (movieType != MovieType.AMOUNT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee.minus(discountAmount);
    }

    public Money calculatePercentDiscountedFee() {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee.minus(fee.times(discountPercent));
    }

    public Money calculateNoneDiscountedFee() {
        if (movieType != MovieType.NONE_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee;
    }

    public boolean isDiscountable(LocalDateTime whenScreened, int sequence) {
        for(DiscountCondition condition : discountConditions) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                if (condition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())) {
                    return true;
                }
            } else {
                if (condition.isDiscountable(sequence)) {
                    return true;
                }
            }
        }

        return false;
    }
}
