package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloServiceAspect {

    // The aspect is the place were we add the logic that is decoupled from the application's code
    // ("execution (* services.HelloService.hello(..))")
    @Before("
    public void before() {
        System.out.println("Before");
    }

}
