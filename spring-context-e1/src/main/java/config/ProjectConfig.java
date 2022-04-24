package config;

import beans.AnotherBean;
import beans.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * The configuration class that will be used by the context. There could be multiple configuration class.
 * In a Spring project you can use XML and annotations at the same time to read configs
 */

@Configuration
public class ProjectConfig {

    /*
     * Specifying a bean using the annotation in order to create an instance of the bean in the Spring context.
     * In this case, even if not usual, the method name will not contain a verb. Anyway it will return an instance
     * of a bean automatically in the context when we use the bean annotation
     */

    // Just returning a default bean
    @Bean
    public MyBean myBean(){
        return new MyBean();
    }

    // Creating an instance, performing operations and returning it
    @Bean
    public AnotherBean anotherBean(){
        AnotherBean ab = new AnotherBean();
        ab.setText("Hello I'm another bean!");
        return ab;
    }
}
