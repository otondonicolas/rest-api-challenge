package com.example.api_store.service;

import com.example.api_store.model.dto.ApiStoreRequestDto;
import com.example.api_store.model.dto.ProductDTO;
import java.sql.Date;
import java.util.List;

public interface IStoreService {
    List<ProductDTO> findAllProducts();
    ProductDTO findProductById(Long id) throws Exception;
    Boolean deleteProductById(Long id) throws Exception;
    Boolean createProduct(ApiStoreRequestDto apiStoreRequestDto) throws Exception;
    ProductDTO modifyProduct(Long id, String productItem, String productDescription, Integer productPrice, Date createdAt, Boolean isInStock);

}
