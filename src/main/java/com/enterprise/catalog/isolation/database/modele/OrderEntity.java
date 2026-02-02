package com.enterprise.catalog.isolation.database.modele;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.enterprise.catalog.noyau.modele.ModeleAccesseur;

import jakarta.persistence.*;
@Entity
@Table(name = "orders")
public class OrderEntity implements ModeleAccesseur {

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "customerId", nullable = false, length = 255)   
private Long customerId;

@Column(name = "orderDate", nullable = true, length = 255)   
private String orderDate;

@Column(name = "totalAmount", nullable = true, length = 255)   
private BigDecimal totalAmount;

@Column(name = "shippingAddress", nullable = true, length = 255)   
private String shippingAddress;

@Column(name = "paymentMethod", nullable = true, length = 255)   
private String paymentMethod;

@Column(name = "status", nullable = false, length = 255)   
private String status;

public OrderEntity() {
}

public OrderEntity(Long customerId, Long id, LocalDate orderDate, BigDecimal totalAmount, String shippingAddress,
        String paymentMethod, String status) {
    this.customerId = customerId;
    this.id = id;
    this.orderDate = orderDate;
    this.totalAmount = totalAmount;
    this.shippingAddress = shippingAddress;
    this.paymentMethod = paymentMethod;
    this.status = status;
}

public Long getCustomerId() {
    return customerId;
}

public void setCustomerId(Long customerId) {
    this.customerId = customerId;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public LocalDate getOrderDate() {
    return orderDate;
}

public void setOrderDate(LocalDate orderDate) {
    this.orderDate = orderDate;
}

public BigDecimal getTotalAmount() {
    return totalAmount;
}

public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
}

public String getShippingAddress() {
    return shippingAddress;
}

public void setShippingAddress(String shippingAddress) {
    this.shippingAddress = shippingAddress;
}

public String getPaymentMethod() {
    return paymentMethod;
}

public void setPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}


    
}
