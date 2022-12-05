package com.braintuck.base.mapper;


import com.braintuck.base.entity.country.Country;
import com.braintuck.base.payload.request.country.CountryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author GhofranAbdelwahab
 * @Date 06 Dec 2022
 **/
@Mapper(componentModel = "spring")
public abstract class CountryMapper {

    @Mapping(target = "name",source = "name")
    @Mapping(target = "zone",source = "zone")
    public abstract Country converter(CountryRequest item);

}
