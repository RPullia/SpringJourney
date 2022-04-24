package main;

import beans.AnotherBean;
import beans.MyBean;
import config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//Main class of the project
public class Main {
    public static void main(String[] args) {

        /*
         * The ApplicationContext is the Spring IoC container.
         * It manages the beans lifecycle reading configurations from XML or annotations.
         *
         * AnnotationConfigApplicationContext will use annotations to read configurations
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // You can ask context to get a bean in order to perform operations on it
        MyBean b1 = context.getBean(MyBean.class);
        b1.setText("Hello I'm a bean!");
        System.out.println(b1.getText());

        // Even if we ask for multiple multiple AnotherBean we will get always the same instance cause AB by default is a Singleton
        AnotherBean ab1 = context.getBean(AnotherBean.class);
        AnotherBean ab2 = context.getBean(AnotherBean.class);

        System.out.println(ab1.getText());
        System.out.println(ab2.getText());
    }
}
