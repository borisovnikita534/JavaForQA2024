package ru.shop.exception;

public class BadOrderCountException extends RuntimeException {
    public BadOrderCountException(long orderCount) {
        super("Order count must be positive " + orderCount);
    }
}
