package com.zipcodewilmington.bakery.repositories;

import com.zipcodewilmington.bakery.models.Baker;
import org.springframework.data.repository.CrudRepository;

public interface BakerRepository extends CrudRepository<Baker, Long> {
}
