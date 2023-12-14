package com.ismaeldev.integrador.repository;

import com.ismaeldev.integrador.domain.Vehicle.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
