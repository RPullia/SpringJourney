package repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*
       Example 1

        @Transactional // Propagation level is REQUIRED by default
        public void addBook(String title, Double price) {  // here is where the transaction is created
            String sql = "INSERT INTO book VALUES (NULL, ?, ?)";
            jdbcTemplate.update(sql, title, price);
        }// here is where the transaction is commited
     */

    /*
        Example 2

        @Transactional (propagation = Propagation.REQUIRES_NEW)
        public void addBook(String title, Double price) {
            String sql = "INSERT INTO book VALUES (NULL, ?, ?)";
            jdbcTemplate.update(sql, title, price);
        }
     */



}
