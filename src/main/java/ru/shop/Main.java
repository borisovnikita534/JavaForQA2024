package ru.shop;

import ru.shop.exception.BadOrderCountException;
import ru.shop.model.Customer;
import ru.shop.model.Order;
import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.OrderRepository;
import ru.shop.repository.ProductRepository;
import ru.shop.service.CustomerService;
import ru.shop.service.OrderService;
import ru.shop.service.ProductService;

import java.util.UUID;

import static ru.shop.model.ProductType.GOOD;

public class Main {
    private static final ProductRepository productRepository = new ProductRepository();
    private static final CustomerRepository customerRepository = new CustomerRepository();
    private static final OrderRepository orderRepository = new OrderRepository();

    private static final ProductService productService = new ProductService(productRepository);
    private static final CustomerService customerService = new CustomerService(customerRepository);
    private static final OrderService orderService = new OrderService(orderRepository);

    public static void main(String[] args) {

        var product1 = new Product();
        product1.setId(UUID.randomUUID());
        product1.setName("product1");
        product1.setCost(99);
        product1.setProductType(GOOD);

        var product2 = new Product();
        product2.setId(UUID.randomUUID());
        product2.setName("product2");
        product2.setCost(115);
        product2.setProductType(ProductType.SERVICE);

        productService.save(product1);
        productService.save(product2);

        var allProducts = productService.findAll();
        System.out.println("products = " + allProducts);


        var customer1 = new Customer();
        customer1.setId(UUID.randomUUID());
        customer1.setName("customer1");
        customer1.setAge(33);
        customer1.setPhone("89874582260");

        var customer2 = new Customer();
        customer2.setId(UUID.randomUUID());
        customer2.setName("customer2");
        customer2.setAge(50);
        customer2.setPhone("8987772222");

        customerService.save(customer1);
        customerService.save(customer2);
        System.out.println("customers = " + customerService.findAll());


        orderService.add(customer1, product1, 1);
        orderService.add(customer2, product2, 4);
        try {
        orderService.add(customer2, product2, -5);
        } catch (BadOrderCountException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }

        System.out.println("customer count: " + customerService.findAll().size());

        System.out.println("product count: " + productService.findAll().size());
        System.out.println("product with type GOOD: " + productService.findByProductType(ProductType.GOOD).size());
        System.out.println("product with type SERVICE: " + productService.findByProductType(ProductType.SERVICE).size());

        System.out.println("order count = " + orderService.findAll().size());
        System.out.println("order count for customer1 = " + orderService.findByCustomer(customer1).size());
        System.out.println("order count for customer2 = " + orderService.findByCustomer(customer2).size());

    }


}