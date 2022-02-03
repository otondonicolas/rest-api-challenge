package com.example.api_store.repository;

import com.example.api_store.model.dto.ProductDTO;
import com.example.api_store.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStoreRepository extends JpaRepository<ProductEntity, Long> {
}
