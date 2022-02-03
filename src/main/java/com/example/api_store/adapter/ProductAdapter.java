package com.example.api_store.adapter;

import com.example.api_store.model.dto.ApiStoreRequestDto;
import com.example.api_store.model.dto.ProductDTO;
import com.example.api_store.model.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductAdapter implements Serializable {

    private static final long serialVersionUID = 6649034392172031629L;

    public List<ProductDTO> entityListToDtoList(List<ProductEntity> entityList) {
        List<ProductDTO> productsList = new ArrayList<>();
        for (ProductEntity entities : entityList) {

            ProductDTO productDTO = ProductDTO.builder()
                    .productId(entities.getProductId())
                    .productItem(entities.getProductItem())
                    .productPrice(entities.getProductPrice())
                    .productDescription(entities.getProductDescription())
                    .createdAt(entities.getCreatedAt())
                    .isInStock(entities.getIsInStock())
                    .build();
            productsList.add(productDTO);
        }
        return productsList;
    }


    public ProductDTO entityToDto(ProductEntity entity) {
        return ProductDTO.builder()
                .productId(entity.getProductId())
                .productItem(entity.getProductItem())
                .productPrice(entity.getProductPrice())
                .productDescription(entity.getProductDescription())
                .createdAt(entity.getCreatedAt())
                .isInStock(entity.getIsInStock())
                .build();
    }

    public ProductEntity dtoToEntity(ApiStoreRequestDto productDTO){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductPrice(productDTO.getProductPrice());
        productEntity.setProductItem(productDTO.getProductItem());
        productEntity.setProductDescription(productEntity.getProductDescription());
        productEntity.setCreatedAt(productDTO.getCreatedAt());
        productEntity.setIsInStock(productDTO.getIsInStock());
        return productEntity;
    }
}

