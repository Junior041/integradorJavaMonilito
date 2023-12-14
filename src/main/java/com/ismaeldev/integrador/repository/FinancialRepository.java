package com.ismaeldev.integrador.repository;

import com.ismaeldev.integrador.domain.Financial.Financial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FinancialRepository extends JpaRepository<Financial, Long> {
    Optional<Financial> findFinancialByStore_StoreId(Long storeId);
}
