package com.example.api_store.repository;

import com.example.api_store.model.dto.ProductDTO;
import com.example.api_store.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

public interface IStoreRepository extends JpaRepository<ProductEntity, Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE `store_database`.`products` SET  `product_item` = ?2, `description` = ?3, `price` = ?4, `created_at` = ?5, `is_in_stock` = ?6 WHERE `product_id` = ?1", nativeQuery = true)
    void modifyAnExistingProduct(Long id, String productItem, String productDescription, Integer productPrice, Date createdAt, Boolean isInStock);
}
