package com.ismaeldev.integrador.service;

import com.ismaeldev.integrador.domain.Brand;
import com.ismaeldev.integrador.domain.Category;
import com.ismaeldev.integrador.domain.Financial.Financial;
import com.ismaeldev.integrador.domain.Vehicle.Photo;
import com.ismaeldev.integrador.domain.Store.Store;
import com.ismaeldev.integrador.domain.Vehicle.Vehicle;
import com.ismaeldev.integrador.dtos.VehicleDTOS;
import com.ismaeldev.integrador.infra.AWS.OperationsS3;
import com.ismaeldev.integrador.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository repository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private OperationsS3 operationsS3;
    @Autowired
    private FinancialService financialService;


    public List<VehicleDTOS> getAllVehicles(){
        List<Vehicle> vehicles = repository.findAll();
        return vehicles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<VehicleDTOS> findVehicleByStoreId(Long id) {
        Optional<List<Vehicle>> vehiclesOptional = this.repository.findVehicleByStore_StoreId(id);

        if (vehiclesOptional.isPresent()) {
            List<Vehicle> vehicles = vehiclesOptional.get();
            return vehicles.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public void createVehicle(VehicleDTOS vehicle, List<MultipartFile> images) throws Exception {
        Store store = this.storeService.findStoreById(vehicle.storeId());
        Category category = this.categoryService.findCategoryById(vehicle.categoryId());
        Brand brand = this.brandService.findBrandById(vehicle.brandId());

        if (category == null || brand == null) {
            throw new Exception("Brand or Category not found");
        }
        this.verifyLimitStore(vehicle.storeId());

        store.setActivesVehicles(store.getActivesVehicles() + 1);

        Vehicle newVehicle = new Vehicle();
        newVehicle.setModel(vehicle.model());
        newVehicle.setCategory(category);
        newVehicle.setPrice(vehicle.price());
        newVehicle.setDescription(vehicle.description());
        newVehicle.setColor(vehicle.color());
        newVehicle.setHp(vehicle.hp());
        newVehicle.setDoors(vehicle.doors());
        newVehicle.setStore(store);
        newVehicle.setBrand(brand);
        newVehicle.setDateInsert(LocalDateTime.now());
        this.repository.save(newVehicle);
        List<Photo> photos = new ArrayList<>();
        for (MultipartFile image : images) {
            var randomName = "009" + LocalDateTime.now() + ".png";
            String keyFile = "lojas/" + newVehicle.getStore().getStoreId() + "/fotos/" + randomName;
            this.operationsS3.saveFile(keyFile, image);

            Photo photo = new Photo();
            photo.setUrl(keyFile);
            photo.setVehicle(newVehicle);
            photo.setDateInsert(LocalDateTime.now());
            photos.add(photo);
        }
        this.photoService.createPhotos(photos);
    }

    public void updateVehicle(Long vehicleId, VehicleDTOS vehicleDTOS) throws Exception {
        Optional<Vehicle> optionalVehicle = repository.findById(vehicleId);

        if (optionalVehicle.isPresent()) {
            Vehicle existingAddress = optionalVehicle.get();
            Store store = storeService.findStoreById(vehicleDTOS.storeId());
            Category category = categoryService.findCategoryById(vehicleDTOS.categoryId());
            Brand brand = brandService.findBrandById(vehicleDTOS.brandId());

            if (category == null || brand == null) {
                throw new Exception("Brand or Category not found");
            }

            existingAddress.setModel(vehicleDTOS.model());
            existingAddress.setCategory(category);
            existingAddress.setPrice(vehicleDTOS.price());
            existingAddress.setDescription(vehicleDTOS.description());
            existingAddress.setColor(vehicleDTOS.color());
            existingAddress.setHp(vehicleDTOS.hp());
            existingAddress.setDoors(vehicleDTOS.doors());
            existingAddress.setStore(store);
            existingAddress.setBrand(brand);
            existingAddress.setDateInsert(LocalDateTime.now());
            this.repository.save(existingAddress);

            repository.save(existingAddress);
        } else {
            throw new Exception("Vehicle not found");
        }
    }

    private void verifyLimitStore(Long storeId) throws Exception {
        Store store = storeService.findStoreById(storeId);
        Optional<Financial> financial = financialService.findFinancialByStoreId(storeId);
        if (financial.isPresent()){
            if (store.getActivesVehicles() >= financial.get().getVehiclesLimit() + financial.get().getAdditionalLimit()){
                throw new Exception("Limit exceeded");
            }
        }

    }

    private VehicleDTOS convertToDTO(Vehicle vehicle) {
        return new VehicleDTOS(
                vehicle.getVehicleId(),
                vehicle.getCategory().getCategoryId(),
                vehicle.getModel(),
                vehicle.getPrice(),
                vehicle.getDescription(),
                vehicle.getColor(),
                vehicle.getHp(),
                vehicle.getDoors(),
                vehicle.getStore().getStoreId(),
                vehicle.getBrand().getBrandId(),
                vehicle.getPhotos()
        );
    }
}
