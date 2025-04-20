package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration // 설정 정보란 말임
// Bean 자동 긁어주기
// @Component 애노테이션이 붙은 애들을 자동으로 Spring Bean으로 등록해줌
@ComponentScan(
        //basePackages = "hello.core.member"
        // 경로 설정 가능 -> member만 컴포넌트 스캔 대상이 됨
        // 탐색할 패키지 시작위치임 하위로 다 찾을 수 있다!
        // default는 현재 파일의 위치부터 하위 패키지까지

        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
// Configuration 어노테이션은 AppConfig 에 쓰여있음 따라서 이걸 제외하고 해줘야함
public class AutoAppConfig {

}
