package org.calling;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class NightDiscountPhoneTest {

    @Test
    void forMoney3000NightPhone() {

        LocalDateTime from = LocalDateTime.of(2021,7,26,23,40, 0);
        LocalDateTime to = LocalDateTime.of(2021,7,26,23,40, 30);
        LocalDateTime start = LocalDateTime.of(2021,7,26,23,40, 10);

        Duration duration = Duration.between(start,to);
        NightDiscountPhone nightDiscountPhone = new NightDiscountPhone(Money.wons(1000), Money.wons(2000), duration);

        assertThat(nightDiscountPhone.calculateFee()).isEqualTo(Money.ZERO);
//        RegularPhone phone = new RegularPhone(Money.wons(3000), duration);
//        phone.call(new PhoneCall(from,to));
//        phone.call(new PhoneCall(from,to));
//        phone.call(new PhoneCall(from,to));
//        assertThat(nightDiscountPhone.calculateFee()).isEqualTo(Money.wons(9000));
    }
}