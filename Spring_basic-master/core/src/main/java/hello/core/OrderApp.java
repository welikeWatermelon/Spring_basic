package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 회원가입과 주문생성하는 주문 앱
public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService(); //멤버관리
//        OrderService orderService = appConfig.orderService(); //주문관리

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L; // 특정 멤버 ID
        Member member = new Member(memberId, "memberA", Grade.VIP); // 특정 멤버 한명 생성
        memberService.join(member); // 멤버관리 -> 멤버 저장소에 저장

        Order order = orderService.createOrder(memberId, "itemA", 10000); // 주문 만들기 (주문관리에서 주문 만들기)

        System.out.println("order = " + order);
    }
}
