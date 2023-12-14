package com.ismaeldev.integrador.dtos;

import com.ismaeldev.integrador.domain.Portal;
import com.ismaeldev.integrador.domain.Store.Store;

public record PortalAccessDTOS(Long id, String storePasswordPortal, Long storeId, Long portalId) {
}
