package com.bonfireadventures.repositories;

import com.bonfireadventures.entities.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends CrudRepository<Country, Integer> {
}
