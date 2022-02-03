package com.example.api_store.controller;

import com.example.api_store.model.dto.ApiStoreRequestDto;
import com.example.api_store.model.dto.ProductDTO;
import com.example.api_store.service.impl.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "unwire_test/v1")
public class StoreController {


    private StoreServiceImpl storeService;

    @Autowired
    public StoreController(StoreServiceImpl storeService){
        this.storeService = storeService;
    }

    @PostMapping("/insert_product")
    public ResponseEntity<Boolean> createProduct(@RequestBody ApiStoreRequestDto apiStoreRequestDto) throws Exception {
        return ResponseEntity.ok(storeService.createProduct(apiStoreRequestDto));
    }


    @GetMapping("/get_all_products")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> productsList = this.storeService.findAllProducts();
        return ResponseEntity.ok(productsList);
    }

    @GetMapping("/get_by_id")
    ResponseEntity<ProductDTO> getProductById(@RequestParam Long id) throws Exception {
        ProductDTO productDTO = this.storeService.findProductById(id);
        return ResponseEntity.ok(productDTO);
    }

    @DeleteMapping("/delete_by_id")
    ResponseEntity<Boolean> deleteProductById(@RequestParam Long id) throws Exception {
        return ResponseEntity.ok(this.storeService.deleteProductById(id));
    }

}
