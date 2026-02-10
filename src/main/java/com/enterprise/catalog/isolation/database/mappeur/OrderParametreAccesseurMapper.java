package com.enterprise.catalog.isolation.database.mappeur;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import com.enterprise.catalog.isolation.database.modele.OrderEntity;
import com.enterprise.catalog.noyau.mappeur.MappeurParametreAccesseur;
import com.enterprise.catalog.service.order.modele.Order;
@Mapper(componentModel = "spring")
@Component
public interface OrderParametreAccesseurMapper extends MappeurParametreAccesseur<Order, OrderEntity>{

    @Mapping(source = "id", target = "id", qualifiedByName = "optionalLongToLong")
    @Mapping(source = "orderDate", target = "orderDate", qualifiedByName = "optionalLocalDateToString")
    @Mapping(source = "status", target = "status", qualifiedByName = "optionalStringToString")
    @Mapping(source = "totalAmount", target = "totalAmount", qualifiedByName = "optionalBigDecimalToBigDecimal")
    @Mapping(source = "shippingAddress", target = "shippingAddress", qualifiedByName = "optionalStringToString")
    @Mapping(source = "paymentMethod", target = "paymentMethod", qualifiedByName = "optionalStringToString")

    OrderEntity map(Order source);

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

    @Named("optionalBigDecimalToBigDecimal")
    default BigDecimal optionalBigDecimalToBigDecimal(Optional<BigDecimal> value) {
        return value.orElse(null);
    }
    
}
