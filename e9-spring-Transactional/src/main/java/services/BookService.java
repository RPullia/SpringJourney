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
    public void addTenBook(){
        for (int i=1; i <= 10; i++){
            bookRepository.addBook("Book"+i, 10.00);
            if (i == 5) throw new RuntimeException("Something went wrong!");
        }
    }
}
