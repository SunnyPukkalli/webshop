package com.examples.webshop.cart.persistence;

import com.examples.webshop.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Integer> {

    Optional<Cart> findByUserId(Integer userId);
}
