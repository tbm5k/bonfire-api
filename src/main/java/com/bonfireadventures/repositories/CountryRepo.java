package com.bonfireadventures.repositories;

import com.bonfireadventures.entities.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepo extends CrudRepository<Country, Integer> {

    @Query(nativeQuery = true, value = "select * from country where continent_continent_id = :continentId and country_id = :countryId")
    Optional<Country> findById(@Param("continentId") int continentId, @Param("countryId") int countryId);
}
