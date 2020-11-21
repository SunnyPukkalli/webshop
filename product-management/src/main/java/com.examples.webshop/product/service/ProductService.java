package com.examples.webshop.product.service;

import com.examples.webshop.product.exception.ProductNotFoundException;
import com.examples.webshop.product.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    Product createOrUpdateProduct(final Product product);

    String deleteProduct(final Integer productId) throws ProductNotFoundException;

    Product fetchProduct(final Integer productId) throws ProductNotFoundException ;

    List<Product> fetchProductsBasedOnParameters(final Map<String,String> filterParameters) throws ProductNotFoundException ;

}
