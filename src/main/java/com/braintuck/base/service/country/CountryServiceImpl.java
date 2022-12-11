package com.braintuck.base.service.country;

import com.braintuck.base.entity.country.Country;
import com.braintuck.base.mapper.CountryMapper;
import com.braintuck.base.payload.request.country.CountryRequest;
import com.braintuck.base.repository.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author GhofranAbdelwahab
 * @Date 06 Dec 2022
 **/

@Slf4j
@Component("CountryServiceImpl")
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository repository;
    @Autowired
    CountryMapper mapper;

    @Override
    public Country insertCountry(CountryRequest countriesRequest) {
        log.info("COUNTRY--INSERT");
        log.info("start convert request body");
        var country = mapper.converter(countriesRequest);
        return repository.insert(country);
    }

    @Override
    public Country updateCountry(CountryRequest countriesRequest, String id) {
        log.info("COUNTRY--UPDATE");
        var country = mapper.converter(countriesRequest);
        return repository.findCountryById(id).map(item -> {
            country.setId(item.getId());
            return repository.save(country);
        }).orElseThrow(this::getCountryNotFoundError);
    }

    @Override
    public void deleteCountryById(String id) {
        log.info("COUNTRY--DELETE");
        repository.deleteById(id);
    }

    @Override
    public Country getCountryById(String id) {
        log.info("COUNTRY--GET--BY--ID");
        return repository.findCountryById(id).orElseThrow(this::getCountryNotFoundError);
    }

    @Override
    public List<Country> listCountry() {
        log.info("COUNTRY--GET--ALL");
        return repository.findAll();
    }


    private RuntimeException getCountryNotFoundError() {
        log.error("getCountryNotFoundError");
        return new RuntimeException("There are no country with this id");
    }
}

