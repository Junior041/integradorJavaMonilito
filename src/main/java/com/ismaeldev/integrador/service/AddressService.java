package com.ismaeldev.integrador.service;

import com.ismaeldev.integrador.domain.Store.Address;
import com.ismaeldev.integrador.domain.Store.Store;
import com.ismaeldev.integrador.dtos.AddressDTOS;
import com.ismaeldev.integrador.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    @Autowired
    private StoreService storeService;
    public List<Address> getAllAddresses(){
        return repository.findAll();
    }
    public Optional<Address> findAddressByPk(Long id){
        return repository.findById(id);
    }
    public void createAddress(AddressDTOS address){
        Store store = storeService.findStoreById(address.storeId());

        Address newAddress = new Address();
        newAddress.setStore(store);
        newAddress.setNeighborhood(address.neighborhood());
        newAddress.setStreet(address.street());
        newAddress.setCity(address.city());
        newAddress.setState(address.state());
        newAddress.setZipCode(address.zipCode());
        newAddress.setDateInsert(LocalDateTime.now());

        repository.save(newAddress);
    }
}
