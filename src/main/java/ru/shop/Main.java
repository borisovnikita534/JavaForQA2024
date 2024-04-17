package ru.shop;

import ru.shop.model.Customer;
import ru.shop.model.Order;
import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.OrderRepository;
import ru.shop.repository.ProductRepository;

import java.util.UUID;

public class Main {
    private static final ProductRepository productRepository = new ProductRepository();
    private static final CustomerRepository customerRepository = new CustomerRepository();
    private static final OrderRepository orderRepository = new OrderRepository();

    public static void main(String[] args) {

        var product1 = new Product();
        product1.setId(UUID.randomUUID());
        product1.setName("product1");
        product1.setCost(99);
        product1.setProductType(ProductType.GOOD);
        System.out.println("product1 = " + product1);
        productRepository.save(product1);

        var product2 = new Product();
        product2.setId(UUID.randomUUID());
        product2.setName("product2");
        product2.setCost(115);
        product2.setProductType(ProductType.GOOD);
        System.out.println("product2 = " + product2);
        productRepository.save(product2);


        var allProducts = productRepository.findAll();
        System.out.println("products = " + allProducts);

        var customer1 = new Customer();
        customer1.setId(UUID.randomUUID());
        customer1.setName("customer1");
        customer1.setAge(33);
        customer1.setPhone("89874582260");
        customerRepository.save(customer1);

        var customer2 = new Customer();
        customer2.setId(UUID.randomUUID());
        customer2.setName("customer2");
        customer2.setAge(50);
        customer2.setPhone("8987772222");
        customerRepository.save(customer2);

        System.out.println("customers = " + customerRepository.findAll());

        var order1 = new Order();
        order1.setId(UUID.randomUUID());
        order1.setCustomerId(customer1.getId());
        order1.setProductId(product1.getId());
        order1.setCount(1);
        order1.setAmount(1000);
        orderRepository.save(order1);

        var order2 = new Order();
        order2.setId(UUID.randomUUID());
        order2.setCustomerId(customer2.getId());
        order2.setProductId(product2.getId());
        order2.setCount(4);
        order2.setAmount(1500);
        orderRepository.save(order2);

        System.out.println("orders = " + orderRepository.findAll());

        System.out.println("orders for customer = " + orderRepository.findCustomerOrders(customer1.getId()));

    }


}