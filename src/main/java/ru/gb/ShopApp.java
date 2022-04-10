package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.JpaConfig;
import ru.gb.dao.cart.CartDao;
import ru.gb.dao.manufacturer.ManufacturerDao;
import ru.gb.dao.product.ProductDao;
import ru.gb.entity.Cart;
import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

import java.util.HashSet;

public class ShopApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
//        ManufacturerDao manufacturerDao = new OLdJdbcManufacturerDao();
        ManufacturerDao manufacturerDao = context.getBean(ManufacturerDao.class);
//        CartDao cartDao = context.getBean(CartDao.class);

//        System.out.println(manufacturerDao.findNameById(3L));
//        for (Manufacturer manufacturer : manufacturerDao.findAll()) {
//            System.out.println(manufacturer);
//        }
//        System.out.println(manufacturerDao.findById(3L));

        // Homework

//        ProductDao productDao = new OldJdbcProductDao();

//        ProductDao productDao = context.getBean(ProductDao.class);
//        for (Product product : productDao.findAll()) {
//            System.out.println(product);
//        }
//        System.out.println(productDao.findById(40L));
//        System.out.println(productDao.findTitleById(40L));

//        Manufacturer testManufacturer = Manufacturer.builder()
//                .name("test")
//                .products(new HashSet<Product>())
//                .build();
//        manufacturerDao.save(testManufacturer);
//        System.out.println(testManufacturer);

//        Product fishProduct = Product.builder()
//                .title("Fish")
//                .cost(new BigDecimal(500))
//                .date(LocalDate.now())
//                .manufacturer(manufacturerDao.findById(11L))
//                .build();
//        productDao.saveOrUpdate(fishProduct);
//        System.out.println(fishProduct);

//        Product product = productDao.findAll().get(5);
//        productDao.delete(product);

        manufacturerDao.deleteById(12L);

//        Cart cart = new Cart();
//        cart.addProduct(product);
//
//        cartDao.save(cart);
    }
}
