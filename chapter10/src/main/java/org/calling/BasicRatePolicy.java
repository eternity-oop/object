package org.calling;

public abstract class BasicRatePolicy implements RatePolicy {

    @Override
    public Money calculateFee(AnyPhone anyPhone) {
//        Abstract Phone에서 코드 차용
//        public Money calculateFee() {
            Money result = Money.ZERO;
            //List<PhoneCall> calls가 아니라, Phone 인자의 List<> 가져오기
            for (PhoneCall call : anyPhone.getCalls()) {
                result.plus(calculateCallFee(call));
            }
            return result;
        }
    //역시 plus안의 calculateCallFee 컴파일 오류니 abstract method 선언
    protected abstract Money calculateCallFee(PhoneCall call);

}
