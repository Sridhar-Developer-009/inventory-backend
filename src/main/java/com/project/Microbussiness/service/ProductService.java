package com.project.Microbussiness.service;

import com.project.Microbussiness.model.Product;
import com.project.Microbussiness.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // NEW: Get products filtered by owner's email
    public List<Product> getProductsByEmail(String email) {
        return productRepository.findByUserEmail(email);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product updateProduct(Long id, Product details) {
        Product product = getProductById(id);
        product.setName(details.getName());
        product.setPrice(details.getPrice());
        product.setQuantity(details.getQuantity());
        product.setSku(details.getSku());
        // Keep the existing userEmail so it stays in their "table"
        product.setUserEmail(details.getUserEmail());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}