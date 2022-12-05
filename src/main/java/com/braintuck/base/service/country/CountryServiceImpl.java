package com.braintuck.base.service.country;

import com.braintuck.base.entity.country.Country;
import com.braintuck.base.mapper.CountryMapper;
import com.braintuck.base.payload.request.country.CountryRequest;
import com.braintuck.base.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author GhofranAbdelwahab
 * @Date 06 Dec 2022
 **/
@Component("CountryServiceImpl")
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository repository;
    @Autowired
    CountryMapper mapper;

    @Override
    public Country insertCountry(CountryRequest countriesRequest) {
        var country = mapper.converter(countriesRequest);
        return repository.insert(country);
    }

    @Override
    public Country updateCountry(CountryRequest countriesRequest, String id) {
        var country = mapper.converter(countriesRequest);
        return repository.findCountryById(id).map(item -> {
            country.setId(item.getId());
            return repository.save(country);
        }).orElseThrow(this::getCountryNotFoundError);
    }

    @Override
    public void deleteCountryById(String id) {
        repository.deleteById(id);
    }

    @Override
    public Country getCountryById(String id) {
        return repository.findCountryById(id).orElseThrow(this::getCountryNotFoundError);
    }

    @Override
    public List<Country> listCountry() {
        return repository.findAll();
    }


    private RuntimeException getCountryNotFoundError() {
        return new RuntimeException("There are no country with this id");
    }
}

