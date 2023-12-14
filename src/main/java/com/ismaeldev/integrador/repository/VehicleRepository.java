package com.ismaeldev.integrador.repository;

import com.ismaeldev.integrador.domain.Vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<List<Vehicle>> findVehicleByStore_StoreId(Long id);
}
