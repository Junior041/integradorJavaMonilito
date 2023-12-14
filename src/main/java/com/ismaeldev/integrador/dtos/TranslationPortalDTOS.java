package com.ismaeldev.integrador.dtos;

import java.time.LocalDateTime;

public record TranslationPortalDTOS(Long id, String termPortal, String termIntegrator, Long portalId, LocalDateTime dateInsert) {
}
