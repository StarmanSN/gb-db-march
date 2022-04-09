package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.DbConfig;
import ru.gb.config.HibernateConfig;
import ru.gb.dao.ManufacturerDao;
import ru.gb.dao.OldJdbcProductDao;
import ru.gb.dao.ProductDao;
import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

public class ShopApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
//        ManufacturerDao manufacturerDao = new OLdJdbcManufacturerDao();
//        ManufacturerDao manufacturerDao = context.getBean(ManufacturerDao.class);
//        System.out.println(manufacturerDao.findNameById(3L));
//        for (Manufacturer manufacturer : manufacturerDao.findAll()) {
//            System.out.println(manufacturer);
//        }
//        System.out.println(manufacturerDao.findNameById(3L));

        // Homework

//        ProductDao productDao = new OldJdbcProductDao();

        ProductDao productDao = context.getBean(ProductDao.class);
        for (Product product : productDao.findAll()) {
            System.out.println(product);
        }
        System.out.println(productDao.findById(40L));
        System.out.println(productDao.findTitleById(40L));

    }
}
