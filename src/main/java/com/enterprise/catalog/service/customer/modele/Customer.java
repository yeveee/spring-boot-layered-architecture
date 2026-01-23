package com.enterprise.catalog.service.customer.modele;

import com.enterprise.catalog.noyau.modele.ModeleInterne;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class Customer implements ModeleInterne{
    
    private Long id;
    private String firstName;
    private Optional<String> lastName;
    private String email;
    private String phone;
    private Optional<LocalDate> registrationDate;
    private Optional<BigDecimal> totalSpent;
    private Optional<Integer> loyaltyPoints;
    private Optional<String> status;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    
    public Customer() {
        this.lastName = Optional.empty();
        this.registrationDate = Optional.empty();
        this.totalSpent = Optional.empty();
        this.loyaltyPoints = Optional.empty();
        this.status = Optional.empty();
    }

    public Customer(Long id, String firstName, String email, String phone, String address, String city, String country,
            String postalCode) {
        this();
        this.id = id;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }

    public Customer(Long id, String firstName, Optional<String> lastName, String email, String phone,
            Optional<LocalDate> registrationDate, Optional<BigDecimal> totalSpent, Optional<Integer> loyaltyPoints,
            Optional<String> status, String address, String city, String country, String postalCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.registrationDate = registrationDate;
        this.totalSpent = totalSpent;
        this.loyaltyPoints = loyaltyPoints;
        this.status = status;
        this.address = address;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    
}
    public boolean isVip() {
        return totalSpent
        .map(s -> s.compareTo(new BigDecimal("1000")) > 0)
        .orElse(false);
    }

    public String getFullName() {
        String last = lastName.orElse("");
        return (firstName + " " + last).trim();
    }

    public boolean canRedeemPoints(int pointsToRedeem) {
        return loyaltyPoints
        .map(p -> p >= pointsToRedeem)
        .orElse(false);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Optional<String> getLastName() {
        return lastName;
    }

    public void setLastName(Optional<String> lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Optional<LocalDate> getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Optional<LocalDate> registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Optional<BigDecimal> getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(Optional<BigDecimal> totalSpent) {
        this.totalSpent = totalSpent;
    }

    public Optional<Integer> getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Optional<Integer> loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public Optional<String> getStatus() {
        return status;
    }

    public void setStatus(Optional<String> status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", phone=" + phone + ", registrationDate=" + registrationDate + ", totalSpent=" + totalSpent
                + ", loyaltyPoints=" + loyaltyPoints + ", status=" + status + ", address=" + address + ", city=" + city
                + ", country=" + country + ", postalCode=" + postalCode + "]";
    }

    
    
}
