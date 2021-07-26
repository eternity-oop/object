package org.calling;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
//dependencies assertj-core RELEASE add in pom.xml
import static org.assertj.core.api.Assertions.assertThat;

class RegularPhoneTest {

    @Test
    void forNoMoneyPhone() {

        LocalDateTime then = LocalDateTime.of(2021,7,26,20,40);
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(then, now);
        double taxRate = 10.0;
        RegularPhone regularPhone = new RegularPhone(Money.wons(0), duration, taxRate);
        assertThat(regularPhone.calculateFee()).isEqualTo(Money.ZERO);
//        regularPhone.call(new PhoneCall(then,now));
//        assertThat(regularPhone.calculateFee()).isEqualTo(Money.ZERO);
    }

    @Test
    void forMoney3000Phone() {

        LocalDateTime from = LocalDateTime.of(2021,7,26,20,40, 0);
        LocalDateTime to = LocalDateTime.of(2021,7,26,20,40, 30);
        LocalDateTime start = LocalDateTime.of(2021,7,26,20,40, 10);

        Duration duration = Duration.between(start,to);
        double taxRate = 10.0;
        RegularPhone regularPhone = new RegularPhone(Money.wons(3000), duration, taxRate);
        assertThat(regularPhone.calculateFee()).isEqualTo(Money.ZERO);
//        regularPhone.call(new PhoneCall(from,to));
//        regularPhone.call(new PhoneCall(from,to));
//        regularPhone.call(new PhoneCall(from,to));
//        assertThat(regularPhone.calculateFee()).isEqualTo(Money.wons(9000));
    }
}