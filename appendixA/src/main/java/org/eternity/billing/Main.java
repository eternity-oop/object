package org.eternity.billing;

import org.eternity.money.Money;

import java.time.Duration;

public class Main {
	public static void main(String[] args) {
//        Phone regularPhone = new Phone(new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)));
//        Phone nightlyDiscountPhone = new Phone(new NightlyDiscountPolicy(Money.wons(5), Money.wons(10), Duration.ofSeconds(10)));

        Phone regularPhone = new Phone(new TaxablePolicy(0.05, new RegularPolicy(Money.wons(10), Duration.ofSeconds(10))));
        Phone regularPhone2 = new Phone(new TaxablePolicy(0.05, new RateDiscountablePolicy(Money.wons(1000), new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)))));

    }
}
