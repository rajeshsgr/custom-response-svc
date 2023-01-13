package com.example.customresponsesvc.web.rest;

import com.example.customresponsesvc.model.Product;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class ProductController {

    @GetMapping("/product")
    ResponseEntity<Product> getProductInfo(){

        Product product = new Product(1,"Book","PC001");
        HttpHeaders responseHeaders = new HttpHeaders();

        responseHeaders.set("Type", product.productCode());
        responseHeaders.set("custom-message", "test");

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(product);
    }
}
