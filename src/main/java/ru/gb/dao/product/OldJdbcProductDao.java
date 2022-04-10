//package ru.gb.dao.product;
//
//import ru.gb.dao.product.ProductDao;
//import ru.gb.entity.Product;
//
//import java.sql.*;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class OldJdbcProductDao implements ProductDao {
//
//    private Connection getConnection() throws SQLException {
//        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/gb_shop", "geek", "geek");
//    }
//
//    private void closeConnection(Connection connection) {
//        if (connection == null) {
//            return;
//        }
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
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
//            connection = getConnection();
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
//            closeConnection(connection);
//        }
//        return (List<Product>) products;
//    }
//
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
