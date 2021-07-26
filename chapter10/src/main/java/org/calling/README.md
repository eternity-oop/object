## INIT
NightPhone은 Phone에 강하게 결합되어 있다. 
List<PhoneCall> 의 추가가 Phone에서만 존재
코드 중복을 해결하기 위해 추상화에 의존한다 

## p333 차이를 메서드로 추출하라
하나의 PhoneCall에 대한 통화 요금을 계산하는 것 
=> calculateCallFee 메서드 EXTRACT해서 calculateFee메서드 일치
```
Phone.class

for PhoneCall :
result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));

NightPhone.class

for PhoneCall:
result.plus(nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
OR
result.plus(regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));

```