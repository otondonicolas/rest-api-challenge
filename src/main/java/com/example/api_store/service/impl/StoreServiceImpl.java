package com.example.api_store.service.impl;

import com.example.api_store.adapter.ProductAdapter;
import com.example.api_store.model.dto.ApiStoreRequestDto;
import com.example.api_store.model.dto.ProductDTO;
import com.example.api_store.model.entity.ProductEntity;
import com.example.api_store.repository.IStoreRepository;
import com.example.api_store.service.IStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StoreServiceImpl implements IStoreService {

    private IStoreRepository storeRepository;
    private ProductAdapter productAdapter;

    @Autowired
    public StoreServiceImpl(IStoreRepository storeRepository, ProductAdapter productAdapter) {
        this.storeRepository = storeRepository;
        this.productAdapter = productAdapter;
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        return getAllProducts();
    }

    @Override
    public ProductDTO findProductById(Long id) {
        return findProduct(id);
    }

    @Override
    public Boolean deleteProductById(Long id) {
        return Boolean.TRUE.equals(findAndDeleteProduct(id));
    }

    @Override
    public Boolean createProduct(ApiStoreRequestDto apiStoreRequestDto) {
        return Boolean.TRUE.equals(createNewProduct(apiStoreRequestDto));
    }

    @Override
    public ProductDTO modifyProduct(Long id, String productItem, String productDescription, Integer productPrice, java.sql.Date createdAt, Boolean isInStock) {
        return modifyAllProduct(id, productItem, productDescription, productPrice, createdAt, isInStock);

    }

    private List<ProductDTO> getAllProducts() {
        try {
            List<ProductEntity> allProducts = this.storeRepository.findAll();
            if (allProducts.isEmpty()) {
                throw new IllegalArgumentException();
            } else {
                return productAdapter.entityListToDtoList(allProducts);
            }
        } catch (IllegalArgumentException e) {
            log.info("This list is empty");
            return Collections.emptyList();
        }
    }

    private Boolean findAndDeleteProduct(Long id) {
        try {
            if (storeRepository.existsById(id)) {
                storeRepository.deleteById(id);
                return true;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            log.info("No object found with that ID");
            return false;
        }
    }

    private ProductDTO findProduct(Long id) {
        try {
            Optional<ProductEntity> productById = storeRepository.findById(id);
            if (productById.isPresent()) {
                return productAdapter.entityToDto(productById.get());
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            log.info("No object found with that ID");
        }
        return null;
    }

    private Boolean createNewProduct(ApiStoreRequestDto requestDto) {
        try {
            if (requestDto != null) {
                storeRepository.save(productAdapter.requestDtoToEntity(requestDto));
                return true;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            log.info("Can't create a new product");
            return false;
        }
    }

    private ProductDTO modifyAllProduct(Long id, String productItem, String productDescription, Integer productPrice, Date createdAt, Boolean isInStock) {
        try {
            this.storeRepository.modifyAnExistingProduct(id, productItem, productDescription, productPrice, createdAt, isInStock);
            return findProductById(id);
        } catch (IllegalArgumentException e) {
            log.info("Bad ID or invalid argument passed");
            return null;
        }
    }
}
