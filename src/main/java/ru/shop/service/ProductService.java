package ru.shop.service;

import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.ProductRepository;

import java.util.List;

public class ProductService {
    private final ProductRepository productRepository;

    public  ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByProductType(ProductType productType) {
//        var list = new ArrayList<Product>();
//        for (Product product : productRepository.findAll()) {
//// другой способ задать условие            if (product.getProductType() == productType) {
//            if (Objects.equals(product.getProductType(), productType)) {
//                list.add(product);
//            }
//        }
//        return list;
        return productRepository .findAll().stream()
                .filter(product -> product.getProductType() == productType)
                .toList();
    }
}
