package com.ismaeldev.integrador.service;

import com.ismaeldev.integrador.domain.Store.Store;
import com.ismaeldev.integrador.dtos.RegisterDTOS;
import com.ismaeldev.integrador.dtos.StoreDTOS;
import com.ismaeldev.integrador.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StoreService {
    @Autowired
    private StoreRepository repository;

    public Store findStoreById(Long id){
        return repository.findById(id).orElse(null);
    }

}
