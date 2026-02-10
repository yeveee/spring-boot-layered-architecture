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
import com.enterprise.catalog.noyau.mappeur.MappeurReponseApi;
import com.enterprise.catalog.service.order.modele.Order;

@Mapper(componentModel = "spring")
@Component
public interface OrderApiReponseMapper extends MappeurReponseApi<Order, OrderApi>{

    @Mapping(source = "id", target = "id", qualifiedByName = "optionalLongToLong")
    @Mapping(source = "orderDate", target = "orderDate", qualifiedByName = "optionalLocalDateToString")
    @Mapping(source = "status", target = "status", qualifiedByName = "optionalStringToString")
    @Mapping(source = "totalAmount", target = "totalAmount", qualifiedByName = "optionalBigDecimalToString")
    @Mapping(source = "shippingAddress", target = "shippingAddress", qualifiedByName = "optionalStringToString")
    @Mapping(source = "paymentMethod", target = "paymentMethod", qualifiedByName = "optionalStringToString")
    OrderApi map(Order source);

    @Named("optionalLongToLong")
    default Long optionalLongToLong(Optional<Long> value) {
        return value.orElse(null);
    }

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
}
