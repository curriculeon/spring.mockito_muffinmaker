package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.repositories.BakerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BakerController {

    private BakerRepository bakerRepository;

    public BakerController(BakerRepository bakerRepository) {
        this.bakerRepository = bakerRepository;
    }

    public ResponseEntity<Iterable<Baker>> index() {
        return new ResponseEntity<>(this.bakerRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Baker> show(Long id) {
        return new ResponseEntity<>(this.bakerRepository.findOne(id), HttpStatus.OK);
    }

    public ResponseEntity<Baker> create(Baker baker) {
        return new ResponseEntity<>(this.bakerRepository.save(baker), HttpStatus.CREATED);
    }

    public ResponseEntity<Baker> update(Long id, Baker baker) {
        Baker foundBaker = bakerRepository.findOne(id);

        foundBaker.setName(baker.getName());
        foundBaker.setSpecialty(baker.getSpecialty());

        return new ResponseEntity<>(this.bakerRepository.save(foundBaker), HttpStatus.OK);
    }

    public ResponseEntity<Boolean> destroy(Long id) {
        this.bakerRepository.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
