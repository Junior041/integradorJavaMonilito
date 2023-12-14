package com.ismaeldev.integrador.controller;

import com.ismaeldev.integrador.domain.Store.Store;
import com.ismaeldev.integrador.dtos.StoreDTOS;
import com.ismaeldev.integrador.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService service;
    @GetMapping("/{storeId}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long storeId){
        Store store = service.findStoreById(storeId);
        return ResponseEntity.ok(store);
    }
}