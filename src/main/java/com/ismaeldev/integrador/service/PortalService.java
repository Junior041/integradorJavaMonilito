package com.ismaeldev.integrador.service;

import com.ismaeldev.integrador.domain.Portal;
import com.ismaeldev.integrador.dtos.PortalDTOS;
import com.ismaeldev.integrador.repository.PortalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PortalService {
    @Autowired
    private PortalRepository repository;

    public void createPortal(PortalDTOS portal){
        Portal newPortal = new Portal();
        newPortal.setName(portal.name());
        newPortal.setUrlPortal(portal.urlPortal());
        newPortal.setUrlApi(portal.urlApi());
        newPortal.setDescription(portal.description());
        newPortal.setDateInsert(LocalDateTime.now());
        repository.save(newPortal);
    }

    public List<PortalDTOS> getAllPortals(){
        List<Portal> portals = repository.findAll();
        if (portals.isEmpty()){
            return Collections.emptyList();
        }
        return portals.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Portal findPortalById(Long id){
        Optional<Portal> portal = repository.findById(id);

        return portal.orElse(null);
    }

    private PortalDTOS convertToDTO(Portal portal) {
        return new PortalDTOS(
                portal.getPortalId(),
                portal.getName(),
                portal.getUrlPortal(),
                portal.getUrlApi(),
                portal.getDescription(),
                portal.getEmail(),
                portal.getPhone()
        );
    }

}
