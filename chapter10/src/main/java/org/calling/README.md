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
## p336 중복 코드를 부모 클래스로 올려라 
추상 클래스로 구현, AbstractPhone을 Phone과 NightPhone이 상속받도록 하자
완전 동일한 public 공통 코드 : calculateFee() 이동
calls와 calculateCallFee메서드 컴파일 오류 발생

calls는 private인스턴스 변수 (어차피 공통 인스턴스 변수) 이동
=> 각 자식 클래스 : Phone의 PhoneCall, List<PhoneCall> 관련 메서드 삭제

calculateCallFee는 Signature은 동일하나 내부 Implementation이 달라서 발생 
 => 추상 메서드 선언 & 자식 클래스 @Override protected 하도록 abstract protected 선언 

## p340 추상화가 핵심이다
공통 코드를 위로 이동시킨 후, 각 클래스는 서로 다른 변경의 이유를 가진다.
AbstractPhone : 전체 통화 목록 계산 방법 바뀔 때 변경 
Phone : 일반 요금제 통화 한 건 계산 방식 변경 시 변경 
NightPhone : 심야 할인 요금제 통화 한 건 계산 방식 변경 시 변경 

### Single Responsibility Principle
### Dependency Inversion Principle 
즉 새로운 요금제는 AbstractPhone extend & @Override calculateCallFee 
### Open-Closed Principle

## p341 세금 추가하기 (공통 수정사항)
추상클래스 Phone에 taxRate인스턴스 변수 추가, 공통 calculateFee()에 for문 후 최후 taxRate() 부과
인스터스 변수가 추가되었기에, 자식클래스의 초기화 로직 추가 필요

# 합성과 유연한 설계 
상속은 부모 / 자식 클래스의 의존성이 compile 타임에 해결되지만 
합성은 run타임에 해결된다. 상속은 is-a관계(부모 코드 재사용)이고 합성은 has-a관계(부분 객체 코드 재사용)이다
즉 상속은 부모의 내부구현을 상세히 알아야 하므로, 결합도가 높아진다. 객체 합성 >> 클래스 상속 
즉 합성은 코드 자체가 아닌, 포함되는 객체의 public interface를 재사용한다. 낮은 결합도 달성 
상속은 whitebox-reuse, 합성은 black-box reuse이다. 

### p358 기본 정책에 세금 정책 조합하기
기본 정책 (시간대 / 통화량) 아닌 부가 정책 (세금 / 약정 할인)은 적용할 수도, 안할 수도, 여러 개를/다른 순서로 조합 가능하다.
NO 상속 (인스턴스 변수 taxRate을 부모한테 추가해서 자식까지 super(); 생성으로 영향미치는 것)
YES 합성 (부모 클래스는 자신의 추상 메서드 호출, 자식은 이 메서드 @Override) 

훅 Hook Method 편의상 기본 구현(abstract 제외 일반 메서드처럼 구현) 제공, 동일 구현이면 @Override불필요
```
//현재의 RegularPhone, NightDiscountPhone 모두 
 사후 부가세 없어서 어차피 fee 그대로 반환 예정 

abstract class Phone {
protected Money afterCalcualted(Money fee) {
    return fee;
}

class RegularPhone { , class NightDiscountPhone { 
Override불필요 

class TaxableRegularPhone extends RegularPhone { 
 생성자 자체는 자신이 진행, 즉 Tax 포함 
 @Override 
 protected Money afterCalculated(Money fee) {
    return fee.plus(fee.times(taxRate));
 }
}



```
