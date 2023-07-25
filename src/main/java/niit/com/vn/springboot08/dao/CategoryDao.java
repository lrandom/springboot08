package niit.com.vn.springboot08.dao;

import niit.com.vn.springboot08.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean insert(String name) {
        try {
            String sql = "INSERT INTO categories(name) VALUES(?)";
            jdbcTemplate.update(sql, name);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean update(int id, String name) {
        try {
            String sql = "UPDATE categories SET name = ? WHERE id = ?";
            jdbcTemplate.update(sql, id, name);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean delete(int id) {
        try {
            String sql = "DELETE FROM categories WHERE id = ?";
            jdbcTemplate.update(sql, id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Category> getAll() {
        String sql = "SELECT * FROM categories";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class));
    }
}
