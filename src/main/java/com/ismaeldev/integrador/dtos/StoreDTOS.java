package com.ismaeldev.integrador.dtos;

import com.ismaeldev.integrador.domain.Store.StoreRole;

public record StoreDTOS(String name, String responsiblePerson, String cnpj, String password, String username, StoreRole role) {
}
