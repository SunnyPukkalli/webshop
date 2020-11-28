package com.examples.webshop.cart.controller;


import com.examples.webshop.cart.exception.CartNotFoundException;
import com.examples.webshop.cart.exception.LineItemsNotFoundException;
import com.examples.webshop.cart.model.Cart;
import com.examples.webshop.cart.model.LineItems;
import com.examples.webshop.cart.service.CartService;
import com.examples.webshop.cart.service.LineItemsService;
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

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private LineItemsService lineItemsService;

    @PostMapping("/cart")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        return new ResponseEntity<>(cartService.createOrUpdateCart(cart), HttpStatus.CREATED);
    }

    @GetMapping("/cart/{cart_id}")
    public ResponseEntity<Cart> fetchCart(@PathVariable(name = "cart_id") String cartId){
        try {
            return new ResponseEntity<>(cartService.fetchCart(Integer.valueOf(cartId)), HttpStatus.OK);
        } catch (CartNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PatchMapping("/cart/{cart_id}")
    public ResponseEntity<Cart> updateCart(@RequestBody Cart cart, @PathVariable(name = "cart_id") String cartId){
        return new ResponseEntity<>(cartService.createOrUpdateCart(cart), HttpStatus.OK);
    }

    @DeleteMapping("/cart/{cart_id}")
    public ResponseEntity<String> deleteCart(@PathVariable(name = "cart_id") String cartId){
        try{
            return new ResponseEntity<>(cartService.deleteCart(Integer.valueOf(cartId)),HttpStatus.OK);
        } catch (CartNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/cart/lineItems")
    public ResponseEntity<List<LineItems>> createLineItems(@RequestBody List<LineItems> lineItems) {
        return new ResponseEntity<>(lineItemsService.createOrUpdateLineItems(lineItems), HttpStatus.CREATED);
    }

    @GetMapping("/cart/{cart_id}/lineItems")
    public ResponseEntity<List<LineItems>> fetchLineItemsByCart(@PathVariable(name = "cart_id") String cartId){
        try {
            return new ResponseEntity<>(lineItemsService.getLineItemsByCart(Integer.valueOf(cartId)), HttpStatus.OK);
        } catch (LineItemsNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PatchMapping("/cart/{cart_id}/lineItems/{item_id}")
    public ResponseEntity<LineItems> updateCart(@RequestBody LineItems item, @PathVariable(name = "cart_id") String cartId, @PathVariable(name = "item_id") String itemId){
        return new ResponseEntity<>(lineItemsService.createOrUpdateLineItems(item), HttpStatus.OK);
    }

    @DeleteMapping("/cart/{cart_id}/lineItems")
    public ResponseEntity<String> deleteCart(@RequestBody List<LineItems> lineItems,@PathVariable(name = "cart_id") String cartId){
            return new ResponseEntity<>(lineItemsService.deleteLineItems(lineItems),HttpStatus.OK);
    }

}

