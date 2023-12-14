package com.ismaeldev.integrador.repository;

import com.ismaeldev.integrador.domain.Portal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortalRepository extends JpaRepository<Portal, Long> {
}
