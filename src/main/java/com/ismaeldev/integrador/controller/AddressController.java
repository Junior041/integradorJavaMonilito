package com.ismaeldev.integrador.controller;

import com.ismaeldev.integrador.domain.Store.Address;
import com.ismaeldev.integrador.dtos.AddressDTOS;
import com.ismaeldev.integrador.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses(){
        List<Address> addresses = addressService.getAllAddresses();
        return ResponseEntity.ok(addresses);
    }

    @PostMapping
    public ResponseEntity<Void> createAddress(@RequestBody AddressDTOS address){
        addressService.createAddress(address);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
