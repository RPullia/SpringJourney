package repositories;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addBook(Book book){
        String sql = "INSERT INTO book VALUES (NULL, ?, ?)";
        jdbcTemplate.update(sql, book.getTitle(), book.getPrice());
    }

    public List<Book> getBooks(){
        String sql = "SELECT * FROM book";
        return jdbcTemplate.query(sql, new RowMapper<Book>(){
            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException{
                Book b = new Book();
                b.setId(resultSet.getInt("idbook"));
                b.setTitle(resultSet.getString("title"));
                b.setPrice(resultSet.getDouble("price"));
                return b;
            }
        });
    }
}
