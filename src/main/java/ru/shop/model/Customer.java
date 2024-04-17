package ru.shop.model;

import lombok.Value;

import java.util.UUID;

@Value
public class Customer {
    UUID id;
    String name;
    String phone;
    long age;
}
