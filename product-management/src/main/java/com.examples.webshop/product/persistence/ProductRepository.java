package com.examples.webshop.product.persistence;

import com.examples.webshop.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ProductRepository extends JpaRepository<Product,Integer> {
}
