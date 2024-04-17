package ru.shop.model;

//1. Product (Товар)
//   1. UUID id
//   2. String name
//   3. long cost
//   4. ProductType productType (enum)

import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private long cost;
    private ProductType productType;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", productType=" + productType +
                '}';
    }
}


