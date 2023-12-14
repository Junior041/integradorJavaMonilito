package com.ismaeldev.integrador.repository;

import com.ismaeldev.integrador.domain.PortalAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PortalAccessRepository extends JpaRepository<PortalAccess, Long> {

    Optional<List<PortalAccess>> findByStore_StoreId(Long storeId);

}
