package ru.shop.service;

import ru.shop.exception.BadOrderCountException;
import ru.shop.model.Customer;
import ru.shop.model.Order;
import ru.shop.model.Product;
import ru.shop.repository.OrderRepository;

import java.util.List;
import java.util.Objects;
import java.util.OptionalLong;
import java.util.UUID;

import static javax.swing.text.html.HTML.Tag.OL;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void add(Customer customer, Product product, long count) {
        if (count <= 0) {
            throw new BadOrderCountException(count);
        }

        var order = new Order();

        order.setId(UUID.randomUUID());
        order.setCustomerId(customer.getId());
        order.setProductId(product.getId());
        order.setCount(count);
        order.setAmount(count * product.getCost());

        orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findByCustomer(Customer customer) {
        return orderRepository.findAll().stream()
                .filter(it -> Objects.equals(it.getCustomerId(), customer.getId()))
                .toList();
    }

    public long getTotalCustomerAmount(Customer customer) {
//        long sum = 0;
//
//        for (Order order : findByCustomer((customer))) {
//            sum += order.getAmount();
//        }
//        return sum;
     return findByCustomer(customer).stream()
             .mapToLong(Order::getAmount)
             .sum();
    }


}
