package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import hello.core.singleton.StatefulService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// 설정정보라는 뜻
public class AppConfig {

    // 여기 Bean이라 적어주면 스프링 컨테이너에 이 메스드들이 모두 등록이됨
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), new FixDiscountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy(); //RateDiscountPolicy()로 변경해줘도 문제없다
        // 즉, 인터페이스로 return 값을 넣어주니 어떤 이 인터페이스를 구현받는 어떤 경우에도 상관없다!
        // 유지보수가 쉬워진다!!

    }

//    @Bean
//    public StatefulService statefulService() {
//        return new StatefulService();
//    }
}
