package com.zipcodewilmington.bakery.services;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.repositories.BakerRepository;

public class BakerService {
    private BakerRepository repository;

    public BakerService(BakerRepository repository) {
        this.repository = repository;
    }

    public Iterable<Baker> index() {
        return repository.findAll();
    }

    public Baker show(Long id) {
        return repository.findOne(id);
    }

    public Baker create(Baker baker) {
        return repository.save(baker);
    }

    public Baker update(Long id, Baker newBakerData) {
        Baker originalBaker = repository.findOne(id);
        originalBaker.setName(newBakerData.getName());
        originalBaker.setSpecialty(newBakerData.getSpecialty());
        return repository.save(originalBaker);
    }

    public Boolean delete(Long id) {
        repository.delete(id);
        return true;
    }
}
