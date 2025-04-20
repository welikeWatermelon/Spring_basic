package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        // 스프링 컨테이너 생성
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        // MemberService의 빈을 조회해서 담아줌
        //  "스프링 컨테이너에서 MemberService 타입으로
        //  등록된 구현체(Bean)를 가져온다"
        MemberService memberService = ac.getBean(MemberService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);
        // 스프링이 등록한 memberService 빈이 실제로 MemberService 타입인지 확인
    }
}
