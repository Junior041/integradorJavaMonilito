package com.ismaeldev.integrador.controller;

import com.ismaeldev.integrador.domain.Brand;
import com.ismaeldev.integrador.dtos.BrandDTOS;
import com.ismaeldev.integrador.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;


    @GetMapping
    public ResponseEntity<List<Brand>> getAllBrands(){
        List<Brand> brands = brandService.getAllBrands();
        return ResponseEntity.ok(brands);
    }

    @PostMapping
    public ResponseEntity<Void> createBrand(@RequestBody BrandDTOS brand){
        brandService.createBand(brand);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
