package com.zipcodewilmington.bakery.Repositories;

import com.zipcodewilmington.bakery.Models.Baker;
import org.springframework.data.repository.CrudRepository;

public interface BakerRepository extends CrudRepository<Baker, Long> {
}
