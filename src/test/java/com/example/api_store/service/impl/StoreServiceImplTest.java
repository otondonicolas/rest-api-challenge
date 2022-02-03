package com.example.api_store.service.impl;

import com.example.api_store.adapter.ProductAdapter;
import com.example.api_store.model.dto.ApiStoreRequestDto;
import com.example.api_store.model.dto.ProductDTO;
import com.example.api_store.model.entity.ProductEntity;
import com.example.api_store.repository.IStoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@ExtendWith(SpringExtension.class)
class StoreServiceImplTest {

    @InjectMocks
    private StoreServiceImpl storeService;

    @Mock
    private IStoreRepository repository;

    @Mock
    private ProductAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllProducts() {
        List<ProductEntity> productEntities = new ArrayList<>();
        List<ProductDTO> productDTOS = new ArrayList<>();

        doReturn(productEntities).when(repository).findAll();
        doReturn(productDTOS).when(adapter).entityListToDtoList(productEntities);

        assertEquals(productDTOS, storeService.findAllProducts());
    }

    @Test
    void findProductById() throws Exception {
        ProductDTO productDto = ProductDTO.builder().build();
        Optional<ProductEntity> productEntityOptional = Optional.of(new ProductEntity());

        doReturn(productEntityOptional).when(repository).findById(anyLong());
        doReturn(productDto).when(adapter).entityToDto(productEntityOptional.get());

        assertEquals(productDto, storeService.findProductById(anyLong()));
    }

    @Test
    void deleteProductById() throws Exception {
        //I didn't expend so much time here because deleteById method is a void method.
        assertTrue(storeService.deleteProductById(anyLong()));
    }

    @Test
    void createProduct() throws Exception {
        ApiStoreRequestDto apiStoreRequestDto = ApiStoreRequestDto.builder().build();
        assertTrue(storeService.createProduct(apiStoreRequestDto));
    }
}