package config;

import beans.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "beans")
public class ProjectConfig {

    @Bean
    @Qualifier("book1")
    public Book book1(){
        Book b = new Book();
        b.setTitle("The Hobbit");
        return b;
    }

    @Bean
    @Qualifier("book2")
    public Book book2(){
        Book b = new Book();
        b.setTitle("The subtle art of not giving a f**k!");
        return b;
    }
}
