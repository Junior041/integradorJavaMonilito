package com.ismaeldev.integrador.controller;

import com.ismaeldev.integrador.dtos.VehicleDTOS;
import com.ismaeldev.integrador.infra.Security.VerifyTokenWithStoreId;
import com.ismaeldev.integrador.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    private VerifyTokenWithStoreId verifyTokenWithStoreId;
    @GetMapping
    public ResponseEntity<List<VehicleDTOS>> getAllVehicle(){
        List<VehicleDTOS> vehicleDTOs = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicleDTOs);
    }
    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<VehicleDTOS>>findVehicleByStoreId(@PathVariable Long storeId){
        List<VehicleDTOS> vehicleDTOs = vehicleService.findVehicleByStoreId(storeId);
        return ResponseEntity.ok(vehicleDTOs);
    }
    @PostMapping
    public ResponseEntity<Void> createVehicle(@ModelAttribute VehicleDTOS vehicle, @RequestParam("images") List<MultipartFile> images) throws Exception {
        vehicleService.createVehicle(vehicle, images);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{vehicleId}")
    public ResponseEntity<Void> updateVehicle(@RequestBody VehicleDTOS vehicle, @PathVariable Long vehicleId) throws Exception {
        VerifyTokenWithStoreId.verify(vehicle.storeId());

        vehicleService.updateVehicle(vehicleId, vehicle);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
