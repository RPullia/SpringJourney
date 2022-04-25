package main;

import beans.Book;
import beans.Author;
import config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Book b1 = context.getBean(Book.class);
        Author a1 = context.getBean("Author1",Author.class);
        Author a2 = context.getBean("Author2",Author.class);

        System.out.println(b1);
        System.out.println(a1);
        System.out.println(a2);

    }
}
