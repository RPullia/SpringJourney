package main;

import beans.MyBean;
import config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        MyBean b1 = context.getBean(MyBean.class);
        System.out.println(b1.getText());

        //Note that if I create an instance by myself outside the context, I will receive null
        MyBean b2 = new MyBean();
        System.out.println(b2.getText());

    }
}
