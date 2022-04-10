//package ru.gb.dao.product;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.jdbc.core.JdbcTemplate;
//import ru.gb.dao.product.ProductDao;
//import ru.gb.entity.Product;
//
//import java.util.List;
//
////@Component
//@RequiredArgsConstructor
//public class JdbcTemplateProductDao implements ProductDao {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Override
//    public Product findById(Long id) {
//        return null;
//    }
//
//    @Override
//    public String findTitleById(Long id) {
//        return jdbcTemplate.queryForObject("SELECT title FROM product where id = ?", String.class, id);
//    }
//
//    @Override
//    public List<Product> findAll() {
//        return null;
//    }
//
//    @Override
//    public void deleteById(Long id) {
//
//    }
//
//    @Override
//    public Product saveOrUpdate(Product product) {
//        return null;
//    }
//}
