package org.calling;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NightPhoneTest {

    @Test
    void forMoney3000NightPhone() {

        LocalDateTime from = LocalDateTime.of(2021,7,26,23,40, 0);
        LocalDateTime to = LocalDateTime.of(2021,7,26,23,40, 30);
        LocalDateTime start = LocalDateTime.of(2021,7,26,23,40, 10);

        Duration duration = Duration.between(start,to);
        NightPhone nightPhone = new NightPhone(Money.wons(1000), Money.wons(2000), duration);
        assertThat(nightPhone.calculateFee()).isEqualTo(Money.ZERO);
//        phone.call(new PhoneCall(from,to));
//        phone.call(new PhoneCall(from,to));
//        phone.call(new PhoneCall(from,to));
//        assertThat(nightPhone.calculateFee()).isEqualTo(Money.wons(9000));
    }
}