package com.enterprise.catalog.api.order.mappeur;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.enterprise.catalog.api.order.modele.OrderApi;
import com.enterprise.catalog.noyau.mappeur.MappeurParametreApi;
import com.enterprise.catalog.service.order.modele.Order;

@Mapper(componentModel = "spring")
@Component
public interface OrderApiParametreMapper extends MappeurParametreApi<OrderApi, Order> {

    @Mapping(source = "lastName", target = "lastName", qualifiedByName = "stringToOptionalString")

    
}
