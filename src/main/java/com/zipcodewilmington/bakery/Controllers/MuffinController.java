package com.zipcodewilmington.bakery.Controllers;

import com.zipcodewilmington.bakery.Models.Muffin;
import com.zipcodewilmington.bakery.Repositories.MuffinRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MuffinController {

    private MuffinRepository muffinRepository;

    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(this.muffinRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Muffin> show(Long id) {
        return new ResponseEntity<>(this.muffinRepository.findOne(id), HttpStatus.OK);
    }

    public ResponseEntity<Muffin> create(Muffin muffin) {
        return new ResponseEntity<>(this.muffinRepository.save(muffin), HttpStatus.CREATED);
    }

    public ResponseEntity<Muffin> update(Long id, Muffin muffin) {
        Muffin foundMuffin = muffinRepository.findOne(id);
        foundMuffin.setFlavor(muffin.getFlavor());

        return new ResponseEntity<>(this.muffinRepository.save(foundMuffin), HttpStatus.OK);
    }

    public ResponseEntity<Boolean> destroy(Long id) {
        this.muffinRepository.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
