package com.ismaeldev.integrador.service;

import com.ismaeldev.integrador.domain.Vehicle.Photo;
import com.ismaeldev.integrador.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {
    @Autowired
    private PhotoRepository repository;

    public void createPhotos(List<Photo> photos) {
        repository.saveAll(photos);
    }
}
