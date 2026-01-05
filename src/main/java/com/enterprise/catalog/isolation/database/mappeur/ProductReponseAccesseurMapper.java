package com.enterprise.catalog.isolation.database.mappeur;

import com.enterprise.catalog.isolation.database.modele.ProductEntity;
import com.enterprise.catalog.service.product.modele.Product;
import com.enterprise.catalog.noyau.mappeur.MappeurReponseAccesseur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Mapper(componentModel = "spring")
@Component
public interface ProductReponseAccesseurMapper extends MappeurReponseAccesseur<ProductEntity, Product> {

    @Mapping(source = "id", target = "id", qualifiedByName = "longToOptionalLong")
    @Mapping(source = "description", target = "description", qualifiedByName = "stringToOptionalString")
    @Mapping(source = "price", target = "price", qualifiedByName = "bigDecimalToOptionalBigDecimal")
    @Mapping(source = "category", target = "category", qualifiedByName = "stringToOptionalString")
    Product map(ProductEntity source);

    @Named("longToOptionalLong")
    default Optional<Long> longToOptionalLong(Long value) {
        return Optional.ofNullable(value);
    }

    @Named("stringToOptionalString")
    default Optional<String> stringToOptionalString(String value) {
        return Optional.ofNullable(value);
    }

    @Named("bigDecimalToOptionalBigDecimal")
    default Optional<BigDecimal> bigDecimalToOptionalBigDecimal(BigDecimal value) {
        return Optional.ofNullable(value);
    }
}