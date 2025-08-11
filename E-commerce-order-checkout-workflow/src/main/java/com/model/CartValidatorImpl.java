package com.model;

import org.springframework.stereotype.Service;

@Service
public class CartValidatorImpl implements CartValidator {
    @Override
    public boolean validateCart(String cartId) {
        return cartId != null && !cartId.trim().isEmpty();
    }
}