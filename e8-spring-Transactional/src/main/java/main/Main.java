package main;

import config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.BookService;

public class Main {
    public static void main(String[] args) throws Exception{
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        BookService bs = context.getBean(BookService.class);
        bs.addOneBook();
    }
}
