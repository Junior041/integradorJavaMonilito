package com.ismaeldev.integrador.controller;

import com.ismaeldev.integrador.domain.PortalAccess;
import com.ismaeldev.integrador.dtos.PortalAccessDTOS;
import com.ismaeldev.integrador.dtos.PortalDTOS;
import com.ismaeldev.integrador.service.PortalAccessService;
import com.ismaeldev.integrador.service.PortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portal-access")
public class PortalAccessController {
    @Autowired
    private PortalAccessService portalAccessService;

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<PortalAccess>> findPortalAccessByStoreId(@PathVariable Long storeId){
        return ResponseEntity.ok(portalAccessService.findPortalAccessByStoreId(storeId));
    }

    @PostMapping
    public ResponseEntity<Void> createPortalAccess(@RequestBody PortalAccessDTOS portalAccessDTOS) throws Exception {
        portalAccessService.createPortalAccess(portalAccessDTOS);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
