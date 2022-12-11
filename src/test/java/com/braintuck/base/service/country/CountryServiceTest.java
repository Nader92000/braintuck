package com.braintuck.base.service.country;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CountryServiceTest {

    @Autowired
    @Qualifier("CountryServiceImpl")
    private CountryService service;


    @Test
    @DisplayName("Get Country By Id -> Expected Exception")
    void when_getCountryById_ExpectException() {
        assertThrows(RuntimeException.class, () -> {
            service.getCountryById("HAMDA");
        });
    }
}
