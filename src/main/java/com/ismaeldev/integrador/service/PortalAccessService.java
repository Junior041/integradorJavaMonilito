package com.ismaeldev.integrador.service;

import com.ismaeldev.integrador.domain.Portal;
import com.ismaeldev.integrador.domain.PortalAccess;
import com.ismaeldev.integrador.domain.Store.Store;
import com.ismaeldev.integrador.dtos.PortalAccessDTOS;
import com.ismaeldev.integrador.repository.PortalAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PortalAccessService {
    @Autowired
    private PortalAccessRepository repository;
    @Autowired
    private StoreService storeService;
    @Autowired
    private PortalService portalService;

    public void createPortalAccess(PortalAccessDTOS portalAccessDTOS) throws Exception {
        try {
            Store store = storeService.findStoreById(portalAccessDTOS.storeId());
            Portal portal =  portalService.findPortalById(portalAccessDTOS.portalId());

            if (portal == null || store == null) {
                throw new Exception("Portal or Store not found");
            }

            PortalAccess newPortalAccess = new PortalAccess();
            newPortalAccess.setStore(store);
            newPortalAccess.setPortal(portal);
            newPortalAccess.setStorePasswordPortal(portalAccessDTOS.storePasswordPortal());
            newPortalAccess.setDateInsert(LocalDateTime.now());
            repository.save(newPortalAccess);

        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public List<PortalAccess> findPortalAccessByStoreId(Long storeId) {
        Optional<List<PortalAccess>> portalAccess = repository.findByStore_StoreId(storeId);
        return portalAccess.orElse(null);

    }

}
