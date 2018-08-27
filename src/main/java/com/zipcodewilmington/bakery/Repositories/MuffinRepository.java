package com.zipcodewilmington.bakery.Repositories;

import com.zipcodewilmington.bakery.Models.Muffin;
import org.springframework.data.repository.CrudRepository;

public interface MuffinRepository extends CrudRepository<Muffin, Long> {
}
