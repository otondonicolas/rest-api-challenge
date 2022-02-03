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
        List<ProductEntity> allProducts = this.storeRepository.findAll();
        return productAdapter.entityListToDtoList(allProducts);
    }

    @Override
    public ProductDTO findProductById(Long id) throws Exception {
        Optional<ProductEntity> productById = storeRepository.findById(id);
        try {
            if (productById.isPresent()) {
                return productAdapter.entityToDto(productById.get());
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception();
        }
    }

    @Override
    public Boolean deleteProductById(Long id) throws Exception {
        try {
            storeRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception();
        }
        return true;
    }

    @Override
    public Boolean createProduct(ApiStoreRequestDto apiStoreRequestDto) throws Exception {
        try {
            storeRepository.save(productAdapter.dtoToEntity(apiStoreRequestDto));
        } catch (Exception e) {
            throw new Exception();
        }
        return true;
    }
}
