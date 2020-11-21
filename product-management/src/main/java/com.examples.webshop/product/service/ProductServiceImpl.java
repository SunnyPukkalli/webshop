package com.examples.webshop.product.service;

import com.examples.webshop.product.exception.ProductNotFoundException;
import com.examples.webshop.product.model.Product;
import com.examples.webshop.product.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    final private static String PRODUCT_SUCCESS_MESSAGE = "Product does not exist in the System";
    final private static String PRODUCT_ERROR_MESSAGE = "Product does not exist in the System";

    @Override
    public Product createOrUpdateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public String deleteProduct(Integer productId) throws ProductNotFoundException {

        try{
            productRepository.deleteById(productId);
            return PRODUCT_SUCCESS_MESSAGE;
        } catch (EmptyResultDataAccessException exception) {
            throw new ProductNotFoundException(PRODUCT_ERROR_MESSAGE);
        }
    }

    @Override
    public Product fetchProduct(Integer productId) throws ProductNotFoundException {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(PRODUCT_ERROR_MESSAGE));
    }

    @Override
    public List<Product> fetchProductsBasedOnParameters(Map<String, String> filterParameters) throws ProductNotFoundException {
        return null;
    }
}
