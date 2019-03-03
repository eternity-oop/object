package org.eternity.employee;

import org.eternity.money.Money;

public class SalariedEmployee {
    private String name;
    private Money basePay;

    public SalariedEmployee(String name, Money basePay) {
        this.name = name;
        this.basePay = basePay;
    }

    public Money calculatePay(double taxRate) {
        return basePay.minus(basePay.times(taxRate));
    }
}
