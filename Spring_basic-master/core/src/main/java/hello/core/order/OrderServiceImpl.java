package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository(); <1>

    // 변경될 때 이게 왜 문제일까?
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//-> 이렇게 바꿀때,,,  private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    //여기서 인터페이스 타입으로 선언했지만,
    //구현체(FixDiscountPolicy 또는 RateDiscountPolicy)를 직접 new로 생성하고 있사옵니다.


    // 1. DIP 위반
    // -> "클라이언트(사용자)는 추상(인터페이스)에만 의존하고, 구체(구현체)에 의존하지 말아야 한다"
//    OrderServiceImpl → DiscountPolicy (✔ 추상에 의존)
//    OrderServiceImpl → FixDiscountPolicy / RateDiscountPolicy (❌ 구현에도 의존)


    // 2. OCP 위반
    // -> "기존 코드를 변경하지 않고 확장 가능해야 한다."
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    // → 변경하려면 ↓ 이렇게 기존 코드를 바꿔야 함
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    private final MemberRepository memberRepository; //<1>이 얘로 변함

    // 따라서 이렇게 쓰도록
    private final DiscountPolicy discountPolicy;


    // 이 문제를 해결하려면 누군가가 클라이언트인 OrderServiceImpl에
    // DiscountPolicy의 구현 객체를 대신 생성하고 주입해줘야함

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findByID(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
