package com.example.urbanelite.service;

import com.example.urbanelite.entity.Product;
import com.example.urbanelite.model.ProductModel;
import com.example.urbanelite.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addNewProduct(@org.jetbrains.annotations.NotNull ProductModel newProduct) {
        Product dbProduct = new Product();
        dbProduct.setProductName(newProduct.getProductName());
        dbProduct.setDescription(newProduct.getDescription());
        dbProduct.setPrice(Double.parseDouble(newProduct.getPrice()));
        dbProduct.setProductImage(newProduct.getProductImage());
        final Product save = productRepository.save(dbProduct);
    }
}
