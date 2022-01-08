package com.bonfireadventures.repositories;

import com.bonfireadventures.entities.PricePackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricePackageRepo extends CrudRepository<PricePackage, Integer> {
}
