package com.example.urbanelite.controller;

import com.example.urbanelite.model.ProductModel;
import com.example.urbanelite.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    private  final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/new-product")
    public String createNewProduct(@RequestBody ProductModel newProduct){
        System.out.println(newProduct.getPrice());
        productService.addNewProduct(newProduct);
        return "Product Added";
    }

}
