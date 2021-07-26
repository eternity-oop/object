package org.calling;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
//dependencies assertj-core RELEASE add in pom.xml
import static org.assertj.core.api.Assertions.assertThat;

class RegularPhoneTest {


    @Test
    void forMoney3000Phone() {

        LocalDateTime from = LocalDateTime.of(2021,7,26,20,40, 0);
        LocalDateTime to = LocalDateTime.of(2021,7,26,20,40, 30);
        LocalDateTime start = LocalDateTime.of(2021,7,26,20,40, 10);

        Duration duration = Duration.between(start,to);
        RegularPhone regularPhone = new RegularPhone(Money.wons(3000), duration);
        assertThat(regularPhone.calculateFee()).isEqualTo(Money.ZERO);
//        regularPhone.call(new PhoneCall(from,to));
//        regularPhone.call(new PhoneCall(from,to));
//        regularPhone.call(new PhoneCall(from,to));
//        assertThat(regularPhone.calculateFee()).isEqualTo(Money.wons(9000));
    }
}