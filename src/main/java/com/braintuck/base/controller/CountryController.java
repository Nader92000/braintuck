package com.braintuck.base.controller;

import com.braintuck.base.payload.request.country.CountryRequest;
import com.braintuck.base.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author GhofranAbdelwahab
 * @Date 06 Dec 2022
 **/
@RestController
@RequestMapping(path = "/api")
public class CountryController {

    @Autowired
    @Qualifier("CountryServiceImpl")
    CountryService service;


    @PostMapping(value = "/country")
    public ResponseEntity<?> addCountry(@Valid
                                        @NotNull
                                        @RequestBody CountryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insertCountry(request));
    }

    @PutMapping(value = "/country/{id}")
    public ResponseEntity<?> updateCountry(@NotBlank
                                           @PathVariable("id") String id,
                                           @Valid
                                           @NotNull
                                           @RequestBody CountryRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateCountry(request, id));
    }


    @DeleteMapping(value = "/country/{id}")
    public ResponseEntity<?> deleteCountry(@NotBlank
                                           @PathVariable("id") String id) {
        service.deleteCountryById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/country")
    public ResponseEntity<?> listAllCountries() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listCountry());
    }

    @GetMapping(value = "/country/{id}")
    public ResponseEntity<?> getCountryById(@NotBlank
                                            @PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getCountryById(id));
    }
}
