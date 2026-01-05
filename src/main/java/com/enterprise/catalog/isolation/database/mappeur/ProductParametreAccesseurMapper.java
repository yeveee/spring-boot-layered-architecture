package com.enterprise.catalog.isolation.database.mappeur;

import com.enterprise.catalog.isolation.database.modele.ProductEntity;
import com.enterprise.catalog.service.product.modele.Product;
import com.enterprise.catalog.noyau.mappeur.MappeurParametreAccesseur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Mapper(componentModel = "spring")
@Component
public interface ProductParametreAccesseurMapper extends MappeurParametreAccesseur<Product, ProductEntity> {

    @Mapping(source = "id", target = "id", qualifiedByName = "optionalLongToLong")
    @Mapping(source = "description", target = "description", qualifiedByName = "optionalStringToString")
    @Mapping(source = "price", target = "price", qualifiedByName = "optionalBigDecimalToBigDecimal")
    @Mapping(source = "category", target = "category", qualifiedByName = "optionalStringToString")
    ProductEntity map(Product source);

    @Named("optionalLongToLong")
    default Long optionalLongToLong(Optional<Long> value) {
        return value.orElse(null);
    }

    @Named("optionalStringToString")
    default String optionalStringToString(Optional<String> value) {
        return value.orElse(null);
    }

    @Named("optionalBigDecimalToBigDecimal")
    default BigDecimal optionalBigDecimalToBigDecimal(Optional<BigDecimal> value) {
        return value.orElse(null);
    }
}