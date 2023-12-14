package com.ismaeldev.integrador.controller;

import com.ismaeldev.integrador.dtos.PortalDTOS;
import com.ismaeldev.integrador.service.PortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/portal")
public class PortalController {
    @Autowired
    private PortalService portalService;

    @PostMapping
    public ResponseEntity<Void> createPortal(@RequestBody PortalDTOS portal){
        portalService.createPortal(portal);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PortalDTOS>> getAllPortals(){
        List<PortalDTOS> portalDTOs = portalService.getAllPortals();
        return ResponseEntity.ok(portalDTOs);
    }
}
