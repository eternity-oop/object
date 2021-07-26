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

## p358 기본 정책에 세금 정책 조합하기
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
## p369 기본 정책 합성하기 
그러나 위와 같이 Rate>Tax>Regular, Rate>Tax>Night , Rate>Regular 등 클래스폭발 explosion 발생
단일 상속의 어려움 대신, 합성하기 Phone에 의존하지 않는 Policy정책 인터페이스 분리 필요 

RatePolicy Interface, Phone 인자로 받아 계산된 요금 calculateFee(Phone phone) 오퍼레이션
기본 정책 > 일반요금 , 기본정책 > 심야할인요금 객체 구현 (기본정책 은 공통 요소 많으니 Abstract Class)

```
Class AnyPhone (NO MORE an Abstract Class)

//RatePolicy switchable to subclasses, NO final
    private RatePolicy ratePolicy;
    private List<PhoneCall> calls = new ArrayList<>();

    public AnyPhone(RatePolicy ratePolicy){
        this.ratePolicy = ratePolicy;
    }
```
Phone 내부에 RatePolicy에 대한 참조자가 포함. 다양한 요금정책과 협력 가능해야 해서 '인터페이스'나 '추상클래스' 선언
생성자를 통해 RatePolicy의 Instance에 대한 의존성을 주입받아, Runtime 의존성으로 대체 
Implements 가 아닌 아예 생성 시점에 참조! 

## p373 부가 정책 적용하기
인터페이스였다가, Runtime에 관계 대체
  Phone인스턴스  --- calculateFee(phone:this) --> RegularPolicy의 인스턴스
부가정책이 만약, 기본 정책 이후 약정할인정책, 세금정책 적용된다면 그 사이 interrupt필요

  Phone인스턴스 -- ? --> TaxablePolicy의 인스턴스 --?--> RateDiscountPolicy의 인스턴스 
    --?--> RegularPolicy의 인스턴스

1) Phone은 어떤 인스턴스에게 멧지 전송하는지 몰라야, 즉 Taxable, RateDiscoount, Regular 
   모두 동일 RatePolicy 라는 public interface의 구현체여야 함.
2) Taxable, RateDiscount순서 다를 수 있음, 즉 각 인스턴스가 어떤 정책과도 합성이 가능해야 함. 

=> Abstract Class AdditionalRatePolicy도, BasicRatePolicy처럼
인터페이스 RatePolicy를 구현하며 + 그 자체가 여러 RatePolicy 구현체(Basic~Tax~Rate할인..)와 합성해야 함.
즉 생성자에 RatePolicy 인스턴스를 인자로 받아, 의존성을 주입 

## p376 기본 정책과 부가 정책 합성하기
