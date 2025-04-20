package hello.core.annotation;

import hello.core.discount.DiscountPolicy;
import jdk.jfr.Percentage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,
ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}

//@Component
//@MainDiscountPolicy
//public class RateDiscountPolicy implements DiscountPolicy {
//}
