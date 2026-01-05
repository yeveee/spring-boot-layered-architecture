package com.enterprise.catalog.api.product.mappeur;

import com.enterprise.catalog.api.product.modele.ProductApi;
import com.enterprise.catalog.service.product.modele.Product;
import com.enterprise.catalog.noyau.mappeur.MappeurReponseApi;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Mapper(componentModel = "spring")
@Component
public interface ProductApiReponseMapper extends MappeurReponseApi<Product, ProductApi> {

    @Mapping(source = "id", target = "id", qualifiedByName = "optionalLongToLong")
    @Mapping(source = "description", target = "description", qualifiedByName = "optionalStringToString")
    @Mapping(source = "price", target = "price", qualifiedByName = "optionalBigDecimalToString")
    @Mapping(source = "category", target = "category", qualifiedByName = "optionalStringToString")
    ProductApi map(Product source);

    @Named("optionalLongToLong")
    default Long optionalLongToLong(Optional<Long> value) {
        return value.orElse(null);
    }

    @Named("optionalStringToString")
    default String optionalStringToString(Optional<String> value) {
        return value.orElse(null);
    }

    @Named("optionalBigDecimalToString")
    default String optionalBigDecimalToString(Optional<BigDecimal> value) {
        return value.map(BigDecimal::toString).orElse(null);
    }
}