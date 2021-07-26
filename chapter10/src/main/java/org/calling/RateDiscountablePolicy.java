package org.calling;

public class RateDiscountablePolicy extends AdditionalRatePolicy{
    private final Money discountAmount;

    //super() abstract 부모 생성자 + Money 변수 (tax double과 무관)
    public RateDiscountablePolicy(Money discountAmount, RatePolicy next) {
        super(next);
        this.discountAmount = discountAmount;
    }

    //discountAmount 인스턴스 변수 포함해 @Override minus
    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
