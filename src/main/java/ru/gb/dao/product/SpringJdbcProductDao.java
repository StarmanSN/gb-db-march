//package ru.gb.dao.product;
//
//import lombok.RequiredArgsConstructor;
//import ru.gb.dao.product.ProductDao;
//import ru.gb.entity.Product;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
////@Component
//@RequiredArgsConstructor
//public class SpringJdbcProductDao implements ProductDao {
//
//    private final DataSource dataSource;
//
//    @Override
//    public Product findById(Long id) {
//        return null;
//    }
//
//    @Override
//    public String findTitleById(Long id) {
//        return null;
//    }
//
//    @Override
//    public List<Product> findAll() {
//        Set<Product> products = new HashSet<>();
//        Connection connection = null;
//        try {
//            connection = dataSource.getConnection();
//            PreparedStatement statement = connection.prepareStatement("select * from product");
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                final Product product = Product.builder()
//                        .id(resultSet.getLong("id"))
//                        .title(resultSet.getString("title"))
//                        .build();
//                products.add(product);
//            }
//            statement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return (List<Product>) products;
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
