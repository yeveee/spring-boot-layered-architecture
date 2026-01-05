package com.enterprise.catalog.api.customer.modele;

import com.enterprise.catalog.noyau.modele.ModeleApi;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Customer API model for external communication")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerApi implements ModeleApi{

    @Schema(description = "Customer ID", example = "1")
    @JsonProperty("id")
    private Long id;

    @Schema(description = "First name", example = "First")
    @JsonProperty("firstName")
    private String firstName;

    @Schema(description = "Last name", example = "Last")
    @JsonProperty("lastName")
    private String lastName;

    @Schema(description = "Email address", example = "abc@gmail.com")
    @JsonProperty("email")
    private String email;

    @Schema(description = "Phone number", example = "0644444444")
    @JsonProperty("phone")
    private String phone;

    @Schema(description = "Registration date as String", example = "01/05/2026")
    @JsonProperty("registrationDate")
    private String registrationDate;

    @Schema(description = "Total amount spent as String(for API)", example = "9999")
    @JsonProperty("totalSpent")
    private String totalSpent;

    @Schema(description = "Loyalty points as String", example = "100")
    @JsonProperty("loyaltyPoints")
    private String loyaltyPoints;

    @Schema(description = "Customer status(ACTIVE, VIP, etc.)", example = "ACTIVE")
    @JsonProperty("status")
    private String status;

    @Schema(description = "Street address", example = "X rue xxx")
    @JsonProperty("address")
    private String address;

    @Schema(description = "City", example = "City")
    @JsonProperty("city")
    private String city;

    @Schema(description = "Country", example = "Country")
    @JsonProperty("country")
    private String country;

    @Schema(description = "Postal code", example = "XXXXX")
    @JsonProperty("postalCode")
    private String postalCode;
    
    public CustomerApi() {

    }

    public CustomerApi(Long id, String firstName, String lastName, String email, String phone, String registrationDate, String totalSpent, String loyaltyPoints, String status, String address, String city, String country, String postalCode) {

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

    @Override
    public String toString() {
        return "CustomerApi [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", phone=" + phone + ", registrationDate=" + registrationDate + ", totalSpent=" + totalSpent
                + ", loyaltyPoints=" + loyaltyPoints + ", status=" + status + ", address=" + address + ", city=" + city
                + ", country=" + country + ", postalCode=" + postalCode + ", getClass()=" + getClass() + ", getId()="
                + getId() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getEmail()="
                + getEmail() + ", hashCode()=" + hashCode() + ", getPhone()=" + getPhone() + ", getRegistrationDate()="
                + getRegistrationDate() + ", getTotalSpent()=" + getTotalSpent() + ", getLoyaltyPoints()="
                + getLoyaltyPoints() + ", getStatus()=" + getStatus() + ", getAddress()=" + getAddress()
                + ", getCity()=" + getCity() + ", getCountry()=" + getCountry() + ", getPostalCode()=" + getPostalCode()
                + ", toString()=" + super.toString() + "]";
    }

    
    
}
