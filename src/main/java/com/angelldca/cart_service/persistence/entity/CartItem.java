package com.angelldca.cart_service.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity  // Marca esta clase como una entidad JPA
@Table(name = "cart_items")  // Especifica el nombre de la tabla en la base de datos
public class CartItem {

    @Id  // Marca este campo como la clave primaria
    @GeneratedValue(strategy = GenerationType.AUTO)  // Especifica que el ID será generado automáticamente
    private Long id;

    @Column(name = "product_id", nullable = false)  // Define una columna para el campo productId, no permite nulos
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_image_url")
    private String productImageUrl;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "total_price")
    private Double totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)  // Especifica una relación de muchos a uno con la entidad Cart
    @JoinColumn(name = "cart_id")  // Define la columna de clave foránea que enlaza con la tabla Cart
    private Cart cart;



}