package com.angelldca.cart_service.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private List<CartItem> items;

    @Column(name = "total_items")
    private int totalItems;

    @Column(name = "total_quantity")
    private int totalQuantity;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CartStatus status;

    @Column(name = "coupon_code")
    private String couponCode;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "taxes")
    private Double taxes;

    @Column(name = "final_price")
    private Double finalPrice;
}
