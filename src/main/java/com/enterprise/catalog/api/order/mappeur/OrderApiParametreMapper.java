package com.enterprise.catalog.api.order.mappeur;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import com.enterprise.catalog.api.order.modele.OrderApi;
import com.enterprise.catalog.service.order.modele.Order;
import com.enterprise.catalog.noyau.mappeur.MappeurParametreApi;


@Mapper(componentModel = "spring")
@Component
public interface OrderApiParametreMapper extends MappeurParametreApi<OrderApi, Order> {

    @Mapping(source = "id", target = "id", qualifiedByName = "longToOptionalLong")
    @Mapping(source = "orderDate", target = "orderDate", qualifiedByName = "stringToOptionalLocalDate")
    @Mapping(source = "status", target = "status", qualifiedByName = "stringToOptionalString")
    @Mapping(source = "totalAmount", target = "totalAmount", qualifiedByName = "stringToOptionalBigDecimal")
    @Mapping(source = "shippingAddress", target = "shippingAddress", qualifiedByName = "stringToOptionalString")
    @Mapping(source = "paymentMethod", target = "paymentMethod", qualifiedByName = "stringToOptionalString")

    Order map(OrderApi source);

    @Named("longToOptionalLong")
    default Optional<Long> longToOptionalLong(Long value) {
        return Optional.ofNullable(value);
    }

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
        } catch (DateTimeParseException e) {
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

    
}
