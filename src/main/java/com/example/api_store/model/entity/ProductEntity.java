package com.example.api_store.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_item")
    private String productItem;

    @Column(name = "price")
    private Integer productPrice;

    @Column(name = "description")
    private String productDescription;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "is_in_stock")
    private Boolean isInStock;
}
