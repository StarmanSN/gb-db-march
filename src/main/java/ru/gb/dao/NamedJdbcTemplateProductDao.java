package ru.gb.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class NamedJdbcTemplateProductDao implements ProductDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product findById(Long id) {
        String sql = "SELECT p.id, title, m.id as manufacturer_id, m.NAME as manufacturer_name, COST, MANUFACTURE_DATE\n" +
                "FROM PRODUCT p\n" +
                "         INNER JOIN MANUFACTURER M on p.MANUFACTURER_ID = M.ID\n" +
                "where p.id = 35;";
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productId", id);
        return namedParameterJdbcTemplate.query(sql, namedParameters, new ProductWithManufacturerExtractor());
    }

    @Override
    public String findTitleById(Long id) {
        String sql = "SELECT title FROM product where id = :productId";
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
    }

    @Override
    public Iterable<Product> findAll() {
        String sql = "SELECT * FROM product";
        return namedParameterJdbcTemplate.query(sql, new ProductMapper());
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Product saveOrUpdate(Product product) {
        return null;
    }

    private static class ProductMapper implements RowMapper<Product> {

        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Product.builder()
                    .id(rs.getLong("id"))
                    .title(rs.getString("title"))
                    .build();
        }
    }

    private static class ProductWithManufacturerExtractor implements ResultSetExtractor<Product> {

        @Override
        public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
            Product product = null;
            while (rs.next()) {
                if (product == null) {
                    product = Product.builder()
                            .id(rs.getLong("id"))
                            .title(rs.getString("title"))
                            .cost(rs.getBigDecimal("cost"))
                            .date(rs.getDate("manufacture_date").toLocalDate())
                            .build();
                }
                final Manufacturer manufacturer = Manufacturer.builder()
                        .id(rs.getLong("manufacturer_id"))
                        .name(rs.getString("manufacturer_name"))
                        .build();
                manufacturer.addProduct(product);
            }
            return product;
        }
    }
}
