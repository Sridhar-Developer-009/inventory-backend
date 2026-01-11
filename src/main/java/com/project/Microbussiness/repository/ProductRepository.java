package com.project.Microbussiness.repository;

import com.project.Microbussiness.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * This custom method filters products by the owner's email.
     * It ensures User 1 and User 2 only see their own items.
     */
    List<Product> findByUserEmail(String userEmail);

}