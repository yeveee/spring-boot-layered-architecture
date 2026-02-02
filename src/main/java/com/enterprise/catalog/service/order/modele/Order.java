package com.enterprise.catalog.service.order.modele;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import com.enterprise.catalog.noyau.modele.ModeleInterne;

public class Order implements ModeleInterne{
    
    private Long customerId;
    private Optional<Long> id;
    private Optional<LocalDate> orderDate;
    private Optional<BigDecimal> totalAmount;
    private Optional<String> shippingAddress;
    private Optional<String> paymentMethod;
    private Optional<String> status;
    
    public Order() {
        this.id = Optional.empty();
        this.orderDate = Optional.empty();
        this.totalAmount = Optional.empty();
        this.shippingAddress = Optional.empty();
        this.paymentMethod = Optional.empty();
        this.status = Optional.empty();
    }

    public Order(Long customerId) {
        this();
        this.customerId = customerId;
    }

    public Order(Long customerId, Optional<Long> id, Optional<LocalDate> orderDate, Optional<BigDecimal> totalAmount,
            Optional<String> shippingAddress, Optional<String> paymentMethod, Optional<String> status) {
        this.customerId = customerId;
        this.id = id;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public boolean isCompleted() {
        return status.map(s -> s.equals("DELIVERED") )
        .orElse(false);
    }

    public boolean isExpensive() {
        return totalAmount.map(t -> t.compareTo(new BigDecimal("500")) > 0)
        .orElse(false);
    }

    public boolean canBeCanceled() {
        return status.map(s -> s.equals("PENDING") || 
        s.equals("CONFIRMED"))
        .orElse(false);
    }


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Optional<Long> getId() {
        return id;
    }

    public void setId(Optional<Long> id) {
        this.id = id;
    }

    public Optional<LocalDate> getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Optional<LocalDate> orderDate) {
        this.orderDate = orderDate;
    }

    public Optional<BigDecimal> getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Optional<BigDecimal> totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Optional<String> getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Optional<String> shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Optional<String> getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Optional<String> paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Optional<String> getStatus() {
        return status;
    }

    public void setStatus(Optional<String> status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order [customerId=" + customerId + ", id=" + id + ", orderDate=" + orderDate + ", totalAmount="
                + totalAmount + ", shippingAddress=" + shippingAddress + ", paymentMethod=" + paymentMethod
                + ", status=" + status + "]";
    }

    



    



    

    
}
