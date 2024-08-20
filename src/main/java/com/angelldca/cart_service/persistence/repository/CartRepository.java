package com.angelldca.cart_service.persistence.repository;

import com.angelldca.cart_service.persistence.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
}
