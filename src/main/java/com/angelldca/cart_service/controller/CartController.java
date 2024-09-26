package com.angelldca.cart_service.controller;


import com.angelldca.cart_service.persistence.entity.Cart;
import com.angelldca.cart_service.service.CartService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;




@RestController
@RefreshScope
@RequestMapping("/cart")
public class CartController {



    private final CartService cartService;
    @Value("${price.discount: 35%}")
    private String discount;

    public CartController( CartService cartService) {

        this.cartService = cartService;
    }
    @GetMapping
    public String findAll(){
        return discount;
    }
    @GetMapping("/msg")
    public Object recivedMesage(){
        return cartService.messageRecived();
    }

    @PostMapping
    public Cart createCart(@RequestBody Cart cart){
        return cartService.createCart(cart);
    }
}
