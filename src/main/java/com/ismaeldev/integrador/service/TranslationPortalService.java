package com.ismaeldev.integrador.service;

import com.ismaeldev.integrador.domain.Portal;
import com.ismaeldev.integrador.domain.TranslationsPortal;
import com.ismaeldev.integrador.dtos.TranslationPortalDTOS;
import com.ismaeldev.integrador.repository.TranslationPortalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TranslationPortalService {
    @Autowired
    private TranslationPortalRepository repository;
    @Autowired
    private PortalService portalService;

    public void createTranslationPortal(TranslationPortalDTOS translationPortalDTOS) throws Exception {
        Portal portal = portalService.findPortalById(translationPortalDTOS.portalId());

        if (portal == null){
            throw new Exception("Portal not found");
        }


        TranslationsPortal newTranslationsPortal = new TranslationsPortal();
        newTranslationsPortal.setTermPortal(translationPortalDTOS.termPortal());
        newTranslationsPortal.setTermIntegrator(translationPortalDTOS.termIntegrator());
        newTranslationsPortal.setPortal(portal);
        newTranslationsPortal.setDateInsert(LocalDateTime.now());

        repository.save(newTranslationsPortal);

    }

    public List<TranslationsPortal> findTranslationsPortalByPortalId(Long portalId){
        Optional<List<TranslationsPortal>> OptionalTranslationsPortal = repository.findTranslationsPortalByPortal_PortalId(portalId);
        return OptionalTranslationsPortal.orElse(Collections.emptyList());
    }


}
