package com.ismaeldev.integrador.service;

import com.ismaeldev.integrador.domain.Financial.Financial;
import com.ismaeldev.integrador.domain.Store.Store;
import com.ismaeldev.integrador.dtos.FinancialDTOS;
import com.ismaeldev.integrador.repository.FinancialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class FinancialService {
    @Autowired
    private FinancialRepository repository;
    @Autowired
    private StoreService storeService;

    public void createFinancial(FinancialDTOS financialDTOS) throws Exception {
        Store store = this.storeService.findStoreById(financialDTOS.storeId());
        if (store == null){
            throw new Exception("Store not found");
        }
        if (repository.findFinancialByStore_StoreId(financialDTOS.storeId()).isPresent()){
            throw new Exception("Store already registered");
        }

        Financial newFinancial = new Financial();

        newFinancial.setVehiclesLimit(financialDTOS.vehiclesLimit());
        newFinancial.setAdditionalLimit(financialDTOS.additionalLimit());
        newFinancial.setPrice(financialDTOS.price());
        newFinancial.setStore(store);
        newFinancial.setCoinType(financialDTOS.coinType());
        newFinancial.setDatePayment(financialDTOS.datePayment());
        newFinancial.setAdditionalPrice(financialDTOS.additionalPrice());
        newFinancial.setIsMonthly(financialDTOS.isMonthly());
        newFinancial.setPaymentMethod(financialDTOS.paymentMethod());
        newFinancial.setDateInsert(LocalDateTime.now());

        repository.save(newFinancial);
    }

    public Optional<Financial> findFinancialByStoreId(Long storeId){
        return repository.findFinancialByStore_StoreId(storeId);
    }
}
