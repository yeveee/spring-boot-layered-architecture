package com.enterprise.catalog.isolation.database.modele;

import com.enterprise.catalog.noyau.modele.ModeleAccesseur;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerEntity implements ModeleAccesseur {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "firstName", nullable = false, length = 255)   
private String firstName;
    
@Column(name = "lastName", nullable = true, length = 255)   
private String lastName;

@Column(name = "email", length = 255)   
private String email;

@Column(name = "phone", length = 255)   
private String phone;

@Column(name = "registrationDate", length = 255)   
private String registrationDate;

@Column(name = "totalSpent", length = 255)   
private String totalSpent;

@Column(name = "loyaltyPoints", length = 255)   
private String loyaltyPoints;

@Column(name = "status", length = 255)   
private String status;

@Column(name = "address", length = 255)   
private String address;

@Column(name = "city", length = 255)   
private String city;

@Column(name = "country", length = 255)   
private String country;

@Column(name = "postalCode", length = 255)   
private String postalCode;

public CustomerEntity() {
}

public CustomerEntity(Long id, String firstName, String lastName, String email, String phone, String registrationDate,
        String totalSpent, String loyaltyPoints, String status, String address, String city, String country,
        String postalCode) {
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

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
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

public String getRegistrationDate() {
    return registrationDate;
}

public void setRegistrationDate(String registrationDate) {
    this.registrationDate = registrationDate;
}

public String getTotalSpent() {
    return totalSpent;
}

public void setTotalSpent(String totalSpent) {
    this.totalSpent = totalSpent;
}

public String getLoyaltyPoints() {
    return loyaltyPoints;
}

public void setLoyaltyPoints(String loyaltyPoints) {
    this.loyaltyPoints = loyaltyPoints;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
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




}
