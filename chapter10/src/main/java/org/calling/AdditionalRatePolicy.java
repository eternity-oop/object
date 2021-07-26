package org.calling;

public abstract class AdditionalRatePolicy implements RatePolicy {

    //역시 유연하게 합성해야 하니 NO final
    private final RatePolicy next;
    // next 받는 것도 이제 상속 대상 abstract class 여도
    public AdditionalRatePolicy(RatePolicy next) {
        this.next = next;
    }
    @Override
    //우선 next가 참조하는 인스턴스(runtime)에게 calculateFee 메시지 전송
    public Money calculateFee(AnyPhone anyPhone) {
        Money fee = next.calculateFee(anyPhone);
        return afterCalculated(fee);
    }

    //calculateCallFee처럼, afterCalculated 각 자식클래스에서 구현하도록
    protected abstract Money afterCalculated(Money fee);
}
