package com.braintuck.base.payload.request.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author GhofranAbdelwahab
 * @Date 06 Dec 2022
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String zone;
}
