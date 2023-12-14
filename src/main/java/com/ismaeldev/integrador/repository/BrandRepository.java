package com.ismaeldev.integrador.repository;

import com.ismaeldev.integrador.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    Optional<Brand> findBrandByBrandId(Long id);
}
