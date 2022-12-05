package com.braintuck.base.repository;

import com.braintuck.base.entity.country.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author GhofranAbdelwahab
 * @Date 06 Dec 2022
 **/
@Repository
public interface CountryRepository extends MongoRepository<Country, String> {
    @Query("{_id:{ $eq:?0}}")
    Optional<Country> findCountryById(String id);
}
