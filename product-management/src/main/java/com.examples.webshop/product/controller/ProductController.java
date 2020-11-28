package com.examples.webshop.product.controller;


import com.examples.webshop.product.exception.ProductNotFoundException;
import com.examples.webshop.product.model.Product;
import com.examples.webshop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return  new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/product/{product_id}")
    public ResponseEntity<Product> getProducts(@PathVariable String product_id) {
        try{
            Product product = productService.fetchProduct(Integer.valueOf(product_id));
            return  new ResponseEntity<>(product, HttpStatus.OK);
        } catch (ProductNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PatchMapping("/product/{product_id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product , @PathVariable String product_id) {
        try{
            Product retrievedProduct = productService.fetchProduct(Integer.valueOf(product_id));
            return  new ResponseEntity<>(product, HttpStatus.OK);
        } catch (ProductNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @DeleteMapping("/product/{product_id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String product_id) {
        try{
            String result = productService.deleteProduct(Integer.valueOf(product_id));
            return  new ResponseEntity<>(result, HttpStatus.OK);
        } catch (ProductNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
