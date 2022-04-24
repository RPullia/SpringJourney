package config;

import beans.AnotherBean;
import beans.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {
    
    // Just returning a default bean
    @Bean
    public MyBean myBean(){
        return new MyBean();
    }


    // Defining two bean of the same class (one as Primary), setting a different attribute's value for them
    @Bean
    @Primary
    public AnotherBean anotherBean1(){
        AnotherBean ab = new AnotherBean();
        ab.setText("Hello I'm another bean! The primary one!");
        return ab;
    }

    @Bean
    public AnotherBean anotherBean2(){
        AnotherBean ab = new AnotherBean();
        ab.setText("Hello I'm another bean! But not the Primary...");
        return ab;
    }
}
