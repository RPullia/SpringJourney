package main;

import config.ProjectConfig;
import model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.BookRepository;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        BookRepository bookRepository = context.getBean(BookRepository.class);

        Book b = new Book();
        b.setTitle("The Hobbit");
        b.setPrice(20);

        bookRepository.addBook(b);

    }
}
