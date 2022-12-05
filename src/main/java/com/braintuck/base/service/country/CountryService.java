package com.braintuck.base.service.country;

import com.braintuck.base.entity.country.Country;
import com.braintuck.base.payload.request.country.CountryRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GhofranAbdelwahab
 * @Date 06 Dec 2022
 **/
@Service
public interface CountryService {

    Country insertCountry(CountryRequest request);

    Country updateCountry(CountryRequest request, String id);

    Country getCountryById(String id);

    void deleteCountryById(String id);

    List<Country> listCountry();

}
