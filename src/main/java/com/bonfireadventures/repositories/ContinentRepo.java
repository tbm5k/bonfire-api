package com.bonfireadventures.repositories;

import com.bonfireadventures.entities.Continent;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepo extends CrudRepository<Continent, Integer> {

    void deleteByContinentId(int id);
}
