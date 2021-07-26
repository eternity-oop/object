package org.calling;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class AnyPhoneTest {

    @Test
    void isPhoneWithBasicRate() {
//        LocalDateTime from = LocalDateTime.of(2021,1,1,1,1,10);
//        LocalDateTime to = LocalDateTime.of(2021,1,1,1,1,30);

        AnyPhone anyPhone = new AnyPhone(new RegularPolicy(Money.wons(3000), Duration.ofSeconds(60)));
        assertThat(anyPhone.calculateFee()).isEqualTo(Money.wons(0));
    }

    @Test
    void isPhoneWithRateAdTaxAndNightRate() {
//        LocalDateTime from = LocalDateTime.of(2021,1,1,1,1,10);
//        LocalDateTime to = LocalDateTime.of(2021,1,1,1,1,30);

        AnyPhone anyPhone = new AnyPhone(
                //RateDiscount(discountAmount, next)
                new RateDiscountablePolicy(Money.wons(1000),
                        new TaxablePolicy(0.05,
                                new NightDiscountPolicy(Money.wons(500), Money.wons(300), Duration.ofSeconds(30)))));
        assertThat(anyPhone.calculateFee()).isEqualTo(Money.wons(-1000));
    }
}

