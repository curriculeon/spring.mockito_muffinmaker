package com.zipcodewilmington.bakery.services;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.repositories.MuffinRepository;

public class MuffinService {
    private MuffinRepository repository;

    public MuffinService(MuffinRepository repository) {
        this.repository = repository;
    }

    public Iterable<Muffin> index() {
        return repository.findAll();
    }

    public Muffin show(Long id) {
        return repository.findOne(id);
    }

    public Muffin create(Muffin baker) {
        return repository.save(baker);
    }

    public Muffin update(Long id, Muffin newMuffinData) {
        Muffin originalMuffin = repository.findOne(id);
        originalMuffin.setFlavor(newMuffinData.getFlavor());
        return repository.save(originalMuffin);
    }

    public Boolean delete(Long id) {
        repository.delete(id);
        return true;
    }
}
