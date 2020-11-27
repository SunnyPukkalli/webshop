package com.examples.webshop.category.service;

import com.examples.webshop.category.exception.CategoryNotFoundException;
import com.examples.webshop.category.model.Category;
import com.examples.webshop.category.persistence.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    final private static String CATEGORY_SUCCESS_MESSAGE = "Category deleted Successfully";
    final private static String CATEGORY_NOT_FOUND_MESSAGE = "Category does not exist in the System";

    @Override
    public Category createOrUpdateCategory(Category category) {

        return categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Integer categoryId) throws CategoryNotFoundException {

        // TODO: Add logic to check no products belong to this category before deleting

        try{
            categoryRepository.deleteById(categoryId);
            return CATEGORY_SUCCESS_MESSAGE;
        } catch (EmptyResultDataAccessException exception) {
            throw new CategoryNotFoundException(CATEGORY_NOT_FOUND_MESSAGE);
        }

    }

    @Override
    public Category fetchCategory(Integer categoryId) throws CategoryNotFoundException {

        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(CATEGORY_NOT_FOUND_MESSAGE));

    }

    @Override
    public List<Category> fetchAllCategories() {
        return categoryRepository.findAll();
    }
}
