package com.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    private static final Set<String> inStock = new HashSet<>();

    static {
        inStock.add("item1");
        inStock.add("item2");
        inStock.add("item3");
    }

    @Override
    public boolean isAvailable(String itemId) {
        return inStock.contains(itemId);
    }
}
