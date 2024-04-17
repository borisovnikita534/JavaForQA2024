package ru.shop.model;

import lombok.Value;

import java.util.UUID;

@Value
public class Product {
    UUID id;
    String name;
    long cost;
    ProductType productType;
}
