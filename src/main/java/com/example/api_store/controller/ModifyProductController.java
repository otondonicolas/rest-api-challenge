package com.example.api_store.controller;

import com.example.api_store.model.dto.ApiStoreRequestDto;
import com.example.api_store.model.dto.ProductDTO;
import com.example.api_store.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "unwire_test/v1/modify")
public class ModifyProductController {
    
    //This class is only for show how an interface works. We can put this endpoint in 'StoreController' class and will be the same.

    private IStoreService storeService;

    @Autowired
    public ModifyProductController(IStoreService storeService){
        this.storeService = storeService;
    }


    @PutMapping("/modify_existing_product")
    public ResponseEntity<ProductDTO> modifyProduct(@RequestParam Long id, @RequestBody ApiStoreRequestDto requestDto) {
        ProductDTO modifiedProduct = this.storeService.modifyProduct(
                id, requestDto.getProductItem(), requestDto.getProductDescription(),
                requestDto.getProductPrice(), requestDto.getCreatedAt(), requestDto.getIsInStock());
        return ResponseEntity.ok(modifiedProduct);
    }
}
