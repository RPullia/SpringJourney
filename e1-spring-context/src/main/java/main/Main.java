package main;

import beans.AnotherBean;
import beans.MyBean;
import config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        // AnnotationConfigApplicationContext will use annotations to read configurations
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // You can ask context to get a bean by type (e.g MyBean) in order to perform operations on it
        MyBean b1 = context.getBean(MyBean.class);
        b1.setText("Hello I'm a bean!");
        System.out.println(b1.getText());


        // Even if we ask for multiple AnotherBean we will get always the same instance cause AB by default is a Singleton
        AnotherBean abp1 = context.getBean(AnotherBean.class);
        AnotherBean abp2 = context.getBean(AnotherBean.class);

        System.out.println(abp1.getText());
        System.out.println(abp2.getText());

        //If we don't want the primary bean, we have to use the name of the bean that we want
        AnotherBean abNotPrimary = context.getBean("anotherBean2", AnotherBean.class);
        AnotherBean abWithName = context.getBean("AnotherBeanNo3", AnotherBean.class);

        System.out.println(abNotPrimary.getText());
        System.out.println(abWithName.getText());

    }
}
