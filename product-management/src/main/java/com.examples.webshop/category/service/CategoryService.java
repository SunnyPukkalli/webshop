package com.examples.webshop.category.service;

import com.examples.webshop.category.exception.CategoryNotFoundException;
import com.examples.webshop.category.model.Category;

import java.util.List;

public interface CategoryService {

    Category createOrUpdateCategory(final Category category);

    String deleteCategory(final Integer categoryId) throws CategoryNotFoundException;

    Category fetchCategory(final Integer categoryId) throws CategoryNotFoundException;

    List<Category> fetchAllCategories();
}
