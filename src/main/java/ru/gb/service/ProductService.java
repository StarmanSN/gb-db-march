package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.dao.ProductDao;
import ru.gb.entity.Product;
import ru.gb.entity.enums.Status;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductDao productDao;

    public Product save(Product product) {
        return productDao.save(product);
    }

    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productDao.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional(propagation = Propagation.NEVER, isolation = Isolation.READ_UNCOMMITTED)
    public Long count() {
        return productDao.count();
    }

    public List<Product> findAllActive() {
        return productDao.findAllByStatus(Status.ACTIVE);
    }

    public void disableById(Long id) {
        Optional<Product> product = productDao.findById(id);
        product.ifPresent(p -> {
            p.setStatus(Status.DISABLE);
            productDao.save(p);
        });
    }

    public List<Product> findAll(int page, int size) {
        return productDao.findAll(PageRequest.of(page, size)).getContent();
    }

    public List<Product> findAllSortedById() {
        return productDao.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public List<Product> findAllSorterById(int page, int size) {
        return productDao.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"))).getContent();
    }

}
