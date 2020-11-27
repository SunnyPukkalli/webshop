package com.examples.webshop.cart.service;

import com.examples.webshop.cart.exception.LineItemsNotFoundException;
import com.examples.webshop.cart.model.LineItems;

import java.util.List;

public interface LineItemsService {

    LineItems createOrUpdateLineItems(LineItems lineItem);

    List<LineItems> createOrUpdateLineItems(List<LineItems> lineItems);

    List<LineItems> getLineItemsByCart(Integer cartId) throws LineItemsNotFoundException;

    LineItems getLineItemsById(Integer id) throws LineItemsNotFoundException;

    String deleteLineItems(List<LineItems> items);
}
