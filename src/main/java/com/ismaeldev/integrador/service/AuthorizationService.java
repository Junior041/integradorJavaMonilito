package com.ismaeldev.integrador.service;

import com.ismaeldev.integrador.domain.Store.Store;
import com.ismaeldev.integrador.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class AuthorizationService implements UserDetailsService {
    @Autowired
    private StoreRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findStoreByUsername(username);
    }
}
