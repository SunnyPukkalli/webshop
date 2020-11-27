package com.examples.webshop.cart.persistence;

import com.examples.webshop.cart.model.LineItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LineItemsRepository extends JpaRepository<LineItems,Integer> {

    Optional<List<LineItems>> findByCartId(Integer cartId);
}
