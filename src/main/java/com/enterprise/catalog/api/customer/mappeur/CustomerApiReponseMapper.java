package com.enterprise.catalog.api.customer.mappeur;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import com.enterprise.catalog.api.customer.modele.CustomerApi;
import com.enterprise.catalog.noyau.mappeur.MappeurReponseApi;
import com.enterprise.catalog.service.customer.modele.Customer;

@Mapper(componentModel = "spring")
@Component
public interface CustomerApiReponseMapper extends MappeurReponseApi<Customer, CustomerApi>{

@Mapping(source = "lastName", target = "lastName", qualifiedByName = "optionalStringToString")
@Mapping(source = "registrationDate", target = "registrationDate", qualifiedByName = "optionalLocalDateToString")
@Mapping(source = "totalSpent", target = "totalSpent", qualifiedByName = "optionalBigDecimalToString")
@Mapping(source = "loyaltyPoints", target = "loyaltyPoints", qualifiedByName = "optionalIntegerToString")
@Mapping(source = "status", target = "status", qualifiedByName = "optionalStringToString")

CustomerApi map(Customer source);

@Named("optionalStringToString")
    default String optionalStringToString(Optional<String> value) {
        return value.orElse(null);
    }

    @Named("optionalLocalDateToString")
    default String optionalLocalDateToString(Optional<LocalDate> value) {
        return value.map(LocalDate::toString).orElse(null);
    }

    @Named("optionalBigDecimalToString")
    default String optionalBigDecimalToString(Optional<BigDecimal> value) {
        return value.map(BigDecimal::toString).orElse(null);
    }

    @Named("optionalIntegerToString")
    default String optionalIntegerToString(Optional<Integer> value) {
        return value.map(String::valueOf).orElse(null);
    }
    
}
