package beans;

import org.springframework.stereotype.Component;

@Component
public class Author {

    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author{" +
                "book=" + book +
                '}';
    }
}
