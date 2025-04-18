package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService(); // 멤버 관리 객체 생성 // 여기 바뀜 AppConfig에 의해
//        Member member = new Member(1L, "memberA", Grade.VIP); // 회원가입 <1>

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // AppConfig의 설정정보를 가지고옴 (Bean으로 설정되어 있는 것들을 다 가지고 온다는 뜻)
        // ApplicationContext : 스프링 컨테이너

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // 등록된 Bean들 중에 "memberService"를 찾을거야


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member); // 멤버관리 -> 멤버저장소에 저장

        Member findMember = memberService.findMember(1L);  // 아이디가 1인 멤버를 찾아줌 <2>
        System.out.println("new member = " + member.getName()); // <1> 주솟값 반환
        System.out.println("find member = " + findMember.getName()); // <2> 주솟값 반환

    }
}
