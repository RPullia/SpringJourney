package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void addOneBook(){
        bookRepository.addBook("An unexpected journey", 50.00);
        throw new RuntimeException("Something went wrong Bilbo!");
    }
}
