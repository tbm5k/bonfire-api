package com.bonfireadventures.repositories;

import com.bonfireadventures.entities.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends CrudRepository<Image, Integer> {
}
