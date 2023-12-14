package com.ismaeldev.integrador.controller;

import com.ismaeldev.integrador.dtos.AuthenticationDTOS;
import com.ismaeldev.integrador.domain.Store.Store;
import com.ismaeldev.integrador.domain.Store.StoreRole;
import com.ismaeldev.integrador.dtos.RegisterDTOS;
import com.ismaeldev.integrador.infra.Security.TokenService;
import com.ismaeldev.integrador.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private StoreRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Validated AuthenticationDTOS data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Store) auth.getPrincipal());

        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Validated RegisterDTOS store){
        if (this.repository.findStoreByUsername(store.username()) != null)return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(store.password());

        Store newStore = new Store();
        newStore.setName(store.name());
        newStore.setCnpj(store.cnpj());
        newStore.setResponsiblePerson(store.responsiblePerson());
        newStore.setDateInsert(LocalDateTime.now());
        newStore.setUsername(store.username());
        newStore.setPassword(encryptedPassword);
        newStore.setRole(StoreRole.valueOf(store.role()));
        repository.save(newStore);
        return ResponseEntity.ok().build();
    }
}
