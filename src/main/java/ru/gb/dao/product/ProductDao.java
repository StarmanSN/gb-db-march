package ru.gb.dao.product;

import ru.gb.entity.Product;

import java.util.List;

public interface ProductDao {

//    Product findById(Long id);
//
//    String findTitleById(Long id);

    List<Product> findAll();

    void delete(Product product);

    Product saveOrUpdate(Product product);
}
