package com.ismaeldev.integrador.repository;

import com.ismaeldev.integrador.domain.Store.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    UserDetails findStoreByUsername(String username);
}
