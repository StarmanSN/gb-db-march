package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.JpaConfig;
import ru.gb.dao.CartDao;
import ru.gb.dao.ManufacturerDao;
import ru.gb.dao.ProductDao;
import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;
import ru.gb.service.ProductService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ShopApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
//        ManufacturerDao manufacturerDao = new OLdJdbcManufacturerDao();
        ManufacturerDao manufacturerDao = context.getBean(ManufacturerDao.class);
        CartDao cartDao = context.getBean(CartDao.class);
        ProductDao productDao = context.getBean(ProductDao.class);
        ProductService productService = context.getBean(ProductService.class);
//        System.out.println(manufacturerDao.findNameById(3L));
//        for (Manufacturer manufacturer : manufacturerDao.findAll()) {
//            System.out.println(manufacturer);
//        }
//        System.out.println(manufacturerDao.findById(3L));

//        System.out.println(manufacturerDao.count());

//        ProductDao productDao = new OldJdbcProductDao();


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
//                .manufacturer(manufacturerDao.findById(3L).get())
//                .build();
//
//        productDao.save(fishProduct);

//        System.out.println(fishProduct);

//        Product product = productDao.findAll().get(5);
//        productDao.delete(product);

//        manufacturerDao.deleteById(12L);

//        Cart cart = new Cart();
//        cart.addProduct(product);
//
//        cartDao.save(cart);
//
//        Product product = productService.findById(46L);
//        product.setTitle("Fish");
//        productDao.save(product);

//        productService.disableById(46L);

//        System.out.println(productService.findAllActive());
        System.out.println(productService.findAllSortedById());
    }
}
