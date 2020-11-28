package com.examples.webshop.cart.service;

import com.examples.webshop.cart.exception.LineItemsNotFoundException;
import com.examples.webshop.cart.model.LineItems;
import com.examples.webshop.cart.persistence.LineItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineItemsServiceImpl implements LineItemsService {

    @Autowired
    private LineItemsRepository repository;

    private static final String ITEM_NOT_FOUND_MESSAGE = "Line Items is not present";
    private static final String ITEM_DELETED_MESSAGE = "Line Items removed Successfully";

    @Override
    public LineItems createOrUpdateLineItems(LineItems lineItem) {
        return repository.save(lineItem);
    }

    @Override
    public List<LineItems> createOrUpdateLineItems(List<LineItems> lineItems) {
        return repository.saveAll(lineItems);
    }

    @Override
    public List<LineItems> getLineItemsByCart(Integer cartId) throws LineItemsNotFoundException {
        return repository.findByCartId(cartId)
                .orElseThrow( () -> new LineItemsNotFoundException(ITEM_NOT_FOUND_MESSAGE));
    }

    @Override
    public LineItems getLineItemsById(Integer id) throws LineItemsNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new LineItemsNotFoundException(ITEM_NOT_FOUND_MESSAGE));
    }

    @Override
    public String deleteLineItems(List<LineItems> items) {

        repository.deleteAll(items);
        return ITEM_DELETED_MESSAGE;
    }
}
