package com.ismaeldev.integrador.repository;

import com.ismaeldev.integrador.domain.TranslationsPortal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TranslationPortalRepository extends JpaRepository<TranslationsPortal, Long> {
    Optional<List<TranslationsPortal>> findTranslationsPortalByPortal_PortalId(Long portalId);

}
