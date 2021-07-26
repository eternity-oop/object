package org.calling;

public class TaxablePolicy extends AdditionalRatePolicy {
    private final double taxRatio;

    //implement시 생성자 super() 와 메서드 abstract @Override
    public TaxablePolicy(double taxRatio, RatePolicy next) {
        super(next);
        this.taxRatio = taxRatio;
    }

    //taxRatio 인스턴스 변수 포함해 @Override plus
    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRatio));
    }
}
