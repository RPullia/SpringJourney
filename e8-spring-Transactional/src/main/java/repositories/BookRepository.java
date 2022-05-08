package repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addBook(String title, Double price) {
        String sql = "INSERT INTO book VALUES (NULL, ?, ?)";
        jdbcTemplate.update(sql, title, price);
    }


}
