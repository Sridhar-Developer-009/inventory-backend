package com.project.Microbussiness.controller;

import com.project.Microbussiness.model.Product;
import com.project.Microbussiness.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * UPDATED: Accepts an optional 'email' parameter.
     * If email is provided, it returns only that user's products.
     */
    @GetMapping
    public List<Product> getProducts(@RequestParam(required = false) String email) {
        if (email != null && !email.isEmpty()) {
            return productService.getProductsByEmail(email);
        }
        return productService.getAllProducts();
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public Product addProduct(@RequestBody Product product) {
        // Ensure your React frontend sends 'userEmail' in the JSON body
        return productService.saveProduct(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return ResponseEntity.ok(productService.updateProduct(id, productDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}