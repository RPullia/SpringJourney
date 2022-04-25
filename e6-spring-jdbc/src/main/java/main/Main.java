package main;

import config.ProjectConfig;
import model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.BookRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        BookRepository bookRepository = context.getBean(BookRepository.class);

        //Creating a new row in the Book's table
        Book b = new Book();
        b.setTitle("The Lord of the rings");
        b.setPrice(30);

        //Reading Book's table rows
        bookRepository.addBook(b);
        List<Book> bookList = bookRepository.getBooks();
        bookList.forEach(System.out::println);

    }
}
