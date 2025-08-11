package com.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays; // for demo
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CartValidator cartValidator;

    @Autowired
    private InventoryService inventoryService;

    @Override
    public String checkout(String cartId) {
        if (!cartValidator.validateCart(cartId)) {
            return "Cart is invalid";
        }

        // Simulate fetching cart items:
        Order cart = new Order(cartId, Arrays.asList("item1", "item2", "item3"));
        for (String itemId : cart.getItemIds()) {
            if (!inventoryService.isAvailable(itemId)) {
                return "Item out of stock";
            }
        }
        return "Checkout successful for " + cartId;
    }
}

