package com.ismaeldev.integrador.dtos;

import com.ismaeldev.integrador.domain.Vehicle.Photo;

import java.util.List;

public record VehicleDTOS(
                          Long id,
                          Long categoryId,
                          String model,
                          Float price,
                          String description,
                          String color,
                          Integer hp,
                          Integer doors,
                          Long storeId,
                          Long brandId,
                          List<Photo> photos
) {
}
