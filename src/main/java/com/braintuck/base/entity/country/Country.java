package com.braintuck.base.entity.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

/**
 * @author GhofranAbdelwahab
 * @Date 06 Dec 2022
 **/

@Document(collection = "country")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    @Id
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String zone;
}
