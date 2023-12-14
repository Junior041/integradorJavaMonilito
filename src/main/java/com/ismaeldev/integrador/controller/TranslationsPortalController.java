package com.ismaeldev.integrador.controller;

import com.ismaeldev.integrador.domain.TranslationsPortal;
import com.ismaeldev.integrador.dtos.TranslationPortalDTOS;
import com.ismaeldev.integrador.service.TranslationPortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/translations-portal")
public class TranslationsPortalController {
    @Autowired
    private TranslationPortalService translationPortalService;

    @PostMapping
    public ResponseEntity<Void> createTranslationPortal(@RequestBody TranslationPortalDTOS translationPortalDTOS) throws Exception {
        translationPortalService.createTranslationPortal(translationPortalDTOS);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/portal/{portalId}")
    public ResponseEntity<List<TranslationsPortal>> findTranslationsPortalByPortalId(@PathVariable Long portalId){
        List<TranslationsPortal> translationsPortal = translationPortalService.findTranslationsPortalByPortalId(portalId);
        return ResponseEntity.ok(translationsPortal);
    }
}
