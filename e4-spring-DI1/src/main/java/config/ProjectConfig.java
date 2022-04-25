package config;

import beans.Book;
import beans.Author;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Book book(){
        Book p = new Book();
        p.setTitle("The Hobbit");
        return p;
    }

    //Different ways to wire the Book's bean to the Author's one:
    @Bean("Author1")
    public Author author1(){
        Author a = new Author();
        a.setBook(book());
        return a;
    }

    @Bean("Author2")
    public Author author2(Book book){
        Author a = new Author();
        a.setBook(book);
        return a;
    }


}
