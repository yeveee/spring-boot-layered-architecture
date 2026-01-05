package com.enterprise.catalog.isolation.rest.mappeur;

import com.enterprise.catalog.isolation.rest.modele.ReviewAccesseur;
import com.enterprise.catalog.service.product.modele.Review;
import com.enterprise.catalog.noyau.mappeur.MappeurReponseAccesseur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Mapper(componentModel = "spring")
@Component
public interface ReviewReponseAccesseurMapper extends MappeurReponseAccesseur<ReviewAccesseur, Review> {

    @Mapping(source = "id", target = "id", qualifiedByName = "longToOptionalLong")
    @Mapping(source = "productId", target = "productId", qualifiedByName = "longToOptionalLong")
    @Mapping(source = "rating", target = "rating", qualifiedByName = "integerToOptionalInteger")
    @Mapping(source = "comment", target = "comment", qualifiedByName = "stringToOptionalString")
    @Mapping(source = "reviewerName", target = "reviewerName", qualifiedByName = "stringToOptionalString")
    Review map(ReviewAccesseur source);

    @Named("longToOptionalLong")
    default Optional<Long> longToOptionalLong(Long value) {
        return Optional.ofNullable(value);
    }

    @Named("integerToOptionalInteger")
    default Optional<Integer> integerToOptionalInteger(Integer value) {
        return Optional.ofNullable(value);
    }

    @Named("stringToOptionalString")
    default Optional<String> stringToOptionalString(String value) {
        return Optional.ofNullable(value);
    }
}