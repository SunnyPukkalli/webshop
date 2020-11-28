package com.examples.webshop.cart.service;

import com.examples.webshop.cart.exception.CartNotFoundException;
import com.examples.webshop.cart.model.Cart;
import com.examples.webshop.cart.persistence.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository repository;

    private static final String CART_NOT_FOUND_MESSAGE = "Cart is not present";
    private static final String CART_DELETED_MESSAGE = "Cart removed Successfully";


    @Override
    public Cart createOrUpdateCart(Cart cart) {
        return repository.saveAndFlush(cart);
    }

    @Override
    public String deleteCart(Integer cartId) throws CartNotFoundException {
        try{
            repository.deleteById(cartId);
            return  CART_DELETED_MESSAGE;
        } catch (EmptyResultDataAccessException exception) {
            throw new CartNotFoundException(CART_NOT_FOUND_MESSAGE);
        }

    }

    @Override
    public Cart fetchCart(Integer cartId) throws CartNotFoundException {
        return repository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException(CART_NOT_FOUND_MESSAGE));
    }

    @Override
    public Cart fetchCartByUserId(Integer userId) throws CartNotFoundException {
        return repository.findByUserId(userId)
                .orElseThrow(() -> new CartNotFoundException(CART_NOT_FOUND_MESSAGE));
    }
}
