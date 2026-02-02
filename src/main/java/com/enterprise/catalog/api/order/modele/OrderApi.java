package com.enterprise.catalog.api.order.modele;

import com.enterprise.catalog.noyau.modele.ModeleApi;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Order API model for external communication")
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderApi implements ModeleApi{

    @Schema(description = "Order ID", example = "1")
    @JsonProperty("id")
    private Long id;

    @Schema(description = "Customer ID", example = "1")
    @JsonProperty("customerId")
    private Long customerId;
    
    @Schema(description = "Order Date", example = "")
    @JsonProperty("orderDate")
    private String orderDate;

    @Schema(description = "Status", example = "")
    @JsonProperty("status")
    private String status;

    @Schema(description = "Total Amount", example = "")
    @JsonProperty("totalAmount")
    private String totalAmount;

    @Schema(description = "Shipping Address", example = "")
    @JsonProperty("shippingAddress")
    private String shippingAddress;

    @Schema(description = "Payment Method", example = "")
    @JsonProperty("paymentMethod")
    private String paymentMethod;

    public OrderApi() {
    }

    public OrderApi(Long id, Long customerId, String orderDate, String status, String totalAmount,
            String shippingAddress, String paymentMethod) {
        this.id = id;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
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

    @Override
    public String toString() {
        return "OrderApi [id=" + id + ", customerId=" + customerId + ", orderDate=" + orderDate + ", status=" + status
                + ", totalAmount=" + totalAmount + ", shippingAddress=" + shippingAddress + ", paymentMethod="
                + paymentMethod + ", getClass()=" + getClass() + ", getId()=" + getId() + ", getCustomerId()="
                + getCustomerId() + ", getOrderDate()=" + getOrderDate() + ", getStatus()=" + getStatus()
                + ", getTotalAmount()=" + getTotalAmount() + ", getShippingAddress()=" + getShippingAddress()
                + ", getPaymentMethod()=" + getPaymentMethod() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }

    
    

}
