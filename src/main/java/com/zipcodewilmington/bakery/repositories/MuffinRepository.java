package com.zipcodewilmington.bakery.repositories;

import com.zipcodewilmington.bakery.models.Muffin;
import org.springframework.data.repository.CrudRepository;

public interface MuffinRepository extends CrudRepository<Muffin, Long> {
}
