package com.github.curriculeon.services;

import com.github.curriculeon.models.Muffin;
import com.github.curriculeon.repositories.BakerRepository;
import com.github.curriculeon.models.Baker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Annotations added
 * Monica Deshmukh
 * 9/3/20
 */
@Service
public class BakerService {
    private BakerRepository repository;


    @Autowired
    public BakerService(BakerRepository repository) {
        this.repository = repository;
    }

    //added to study @PostConstruct annotation
  /*  @PostConstruct
    public void addBakers(){
        Baker baker1 = new Baker();
        baker1.setName("baker1Name");
        baker1.setSpecialty("muffinMaker");
        baker1.setEmployeeId("1");

        Baker baker2 = new Baker();
        baker2.setName("baker2Name");
        baker2.setSpecialty("muffinMaker");
        baker2.setEmployeeId("2");

        repository.save(baker1);
        repository.save(baker2);

    }*/

    public Iterable<Baker> index() {
        return repository.findAll();
    }

    public Baker show(Long id) {
        return repository.findById(id).get();
    }

    public Baker create(Baker baker) {
        return repository.save(baker);
    }

    public Baker update(Long id, Baker newBakerData) {
        Baker originalBaker = repository.findById(id).get();
        originalBaker.setName(newBakerData.getName());
        originalBaker.setSpecialty(newBakerData.getSpecialty());
        return repository.save(originalBaker);
    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
