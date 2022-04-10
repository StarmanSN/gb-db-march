package ru.gb.dao.product;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Product;

import java.util.List;

//@Component
@RequiredArgsConstructor
public class HibernateProductDao implements ProductDao {

    private final SessionFactory sessionFactory;

//    @Override
//    @Transactional(readOnly = true)
//    public Product findById(Long id) {
//        return (Product) sessionFactory.getCurrentSession().getNamedQuery("Product.findById")
//                .setParameter("id", id).uniqueResult();
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public String findTitleById(Long id) {
//        return (String) sessionFactory.getCurrentSession().getNamedQuery("Product.findTitleById")
//                .setParameter("id", id).uniqueResult();
//    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Product p").list();
    }

    @Override
    @Transactional
    public void delete(Product product) {
        sessionFactory.getCurrentSession().delete(product);
    }

    @Override
    @Transactional
    public Product saveOrUpdate(Product product) {
        sessionFactory.getCurrentSession().saveOrUpdate(product);
        return product;
    }
}
