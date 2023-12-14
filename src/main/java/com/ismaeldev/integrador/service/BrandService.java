package com.ismaeldev.integrador.service;

import com.ismaeldev.integrador.domain.Brand;
import com.ismaeldev.integrador.dtos.BrandDTOS;
import com.ismaeldev.integrador.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandRepository repository;

    public Brand findBrandById(Long id){
        return this.repository.findBrandByBrandId(id).orElse(null);
    }

    public List<Brand> getAllBrands(){
        return repository.findAll();
    }

    public void createBand(BrandDTOS brand){
        Brand newBrand = new Brand();
        newBrand.setBrand(brand.brand());
        newBrand.setDateInsert(LocalDateTime.now());
        repository.save(newBrand);
    }
}
