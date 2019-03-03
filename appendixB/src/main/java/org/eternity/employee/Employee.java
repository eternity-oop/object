package org.eternity.employee;

import org.eternity.money.Money;

public interface Employee {
    Money calculatePay(double taxRate);
}
