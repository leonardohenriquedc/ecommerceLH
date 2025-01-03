package com.devleo.project.ecommerce.repositories;

import com.devleo.project.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {
}
