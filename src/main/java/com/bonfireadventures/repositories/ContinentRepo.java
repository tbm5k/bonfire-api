package com.bonfireadventures.repositories;

import com.bonfireadventures.entities.Continent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepo extends CrudRepository<Continent, Integer> {
}
