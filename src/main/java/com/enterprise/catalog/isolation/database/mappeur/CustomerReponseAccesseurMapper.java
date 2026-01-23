package com.enterprise.catalog.isolation.database.mappeur;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import com.enterprise.catalog.isolation.database.modele.CustomerEntity;
import com.enterprise.catalog.noyau.mappeur.MappeurReponseAccesseur;
import com.enterprise.catalog.service.customer.modele.Customer;

@Mapper(componentModel = "spring")
@Component
public interface CustomerReponseAccesseurMapper extends MappeurReponseAccesseur<CustomerEntity, Customer> {

@Mapping(source = "lastName", target = "lastName", qualifiedByName = "stringToOptionalString")
@Mapping(source = "registrationDate", target = "registrationDate", qualifiedByName = "stringToOptionalLocalDate")
@Mapping(source = "totalSpent", target = "totalSpent", qualifiedByName = "stringToOptionalBigDecimal")
@Mapping(source = "loyaltyPoints", target = "loyaltyPoints", qualifiedByName = "stringToOptionalInteger")
@Mapping(source = "status", target = "status", qualifiedByName = "stringToOptionalString")

Customer map(CustomerEntity source);

@Named("stringToOptionalString")
    default Optional<String> stringToOptionalString(String value) {
        return Optional.ofNullable(value);
    }

    @Named("stringToOptionalLocalDate")
    default Optional<LocalDate> stringToOptionalLocalDate(String value) {
        if (value == null || value.trim().isEmpty()) {
            return Optional.empty();
        }
        try {
            return Optional.of(LocalDate.parse(value));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    @Named("stringToOptionalBigDecimal")
    default Optional<BigDecimal> stringToOptionalBigDecimal(String value) {
        if (value == null || value.trim().isEmpty()) {
            return Optional.empty();
        }
        try {
            return Optional.of(new BigDecimal(value));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    @Named("stringToOptionalInteger")
    default Optional<Integer> stringToOptionalInteger(String value) {
        if (value == null || value.trim().isEmpty()) {
            return Optional.empty();
        }
        try {
            return Optional.of(Integer.valueOf(value));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    
}
