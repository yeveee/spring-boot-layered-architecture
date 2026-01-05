package com.enterprise.catalog.api.product.mappeur;

import com.enterprise.catalog.api.product.modele.ProductApi;
import com.enterprise.catalog.service.product.modele.Product;
import com.enterprise.catalog.noyau.mappeur.MappeurParametreApi;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Mapper(componentModel = "spring")
@Component
public interface ProductApiParametreMapper extends MappeurParametreApi<ProductApi, Product> {

    @Mapping(source = "id", target = "id", qualifiedByName = "longToOptionalLong")
    @Mapping(source = "description", target = "description", qualifiedByName = "stringToOptionalString")
    @Mapping(source = "price", target = "price", qualifiedByName = "stringToOptionalBigDecimal")
    @Mapping(source = "category", target = "category", qualifiedByName = "stringToOptionalString")
    Product map(ProductApi source);

    @Named("longToOptionalLong")
    default Optional<Long> longToOptionalLong(Long value) {
        return Optional.ofNullable(value);
    }

    @Named("stringToOptionalString")
    default Optional<String> stringToOptionalString(String value) {
        return Optional.ofNullable(value);
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
}