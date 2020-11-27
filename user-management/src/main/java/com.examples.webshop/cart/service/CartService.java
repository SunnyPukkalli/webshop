package com.examples.webshop.cart.service;

import com.examples.webshop.cart.exception.CartNotFoundException;
import com.examples.webshop.cart.model.Cart;

public interface CartService {

    Cart createOrUpdateCart (Cart cart);

    String deleteCart(Integer cartId) throws CartNotFoundException;

    Cart fetchCart(Integer cartId) throws CartNotFoundException;

    Cart fetchCartByUserId(Integer userId) throws CartNotFoundException;

}
