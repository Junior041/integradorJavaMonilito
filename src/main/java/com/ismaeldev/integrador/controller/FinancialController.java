package com.ismaeldev.integrador.controller;

import com.ismaeldev.integrador.domain.Financial.Financial;
import com.ismaeldev.integrador.dtos.FinancialDTOS;
import com.ismaeldev.integrador.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/financial")
public class FinancialController {
    @Autowired
    private FinancialService financialService;

    @PostMapping
    public ResponseEntity<Void> createFinancial(@RequestBody FinancialDTOS finance) throws Exception {
        financialService.createFinancial(finance);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<Optional<Financial>> findFinancialByStoreId(@PathVariable Long storeId){
        return ResponseEntity.ok(financialService.findFinancialByStoreId(storeId));
    }

}
