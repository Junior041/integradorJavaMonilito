package com.ismaeldev.integrador.repository;

import com.ismaeldev.integrador.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findCategoriesByCategoryId(Long id);
}
