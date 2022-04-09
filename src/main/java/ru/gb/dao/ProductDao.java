package ru.gb.dao;

import ru.gb.entity.Product;

import java.util.List;

public interface ProductDao {

    Product findById(Long id);

    String findTitleById(Long id);

    Iterable<Product> findAll();

    void deleteById(Long id);

    Product saveOrUpdate(Product product);
}
