package ru.shop.model;

import lombok.Value;

import java.util.UUID;

@Value
public class Order {
    UUID id;
    UUID customerId;
    UUID productId;
    long count;
    long amount;
}
