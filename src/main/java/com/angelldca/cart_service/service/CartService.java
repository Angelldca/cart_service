package com.angelldca.cart_service.service;

import com.angelldca.cart_service.persistence.entity.Cart;
import com.angelldca.cart_service.persistence.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
    public Cart createCart(Cart cart){
        return cartRepository.save(cart);
    }

    public List<Cart> findAll(){
        return cartRepository.findAll();
    }
}
