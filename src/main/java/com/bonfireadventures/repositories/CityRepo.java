package com.bonfireadventures.repositories;

import com.bonfireadventures.entities.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepo extends CrudRepository<City, Integer> {
}
