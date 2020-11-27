package com.examples.webshop.category.persistence;

import com.examples.webshop.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
