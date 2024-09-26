package com.project.stilgalleriet.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.Set;

public class SignupRequest {
    @NotBlank(message = "Username is mandatory")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters" )
    private String username;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Password is mandatory")
    @Pattern(regexp =
            "^" + //Början av strängan.
            "(?=.*\\d)" + // En positiv lookahead som kräver minst en siffra i strängen.
            "(?=.*[a-z])" + // En positiv lookahead som kräver minst en lite bokstav i strängen.
            "(?=.*[A-Z])" + //En positiv lookahead som kräver minst en stor bokstav i strängen.
            ".{8,40}" + // En positiv lookahead som kräver på att strängen måste innehålla mellan 8 och 40 tecken lång.
            "$", //Slutet av strängen.
            message = "The password must contain at least one uppercase letter, one lowercase letter, one digit and be between 8 to 40 characters long .")

    private String password;
    @NotBlank(message = "First name is mandatory")
    @Size(max = 20, message = "First namne must be less than 20 characters")
    private String firstName;
    @NotBlank(message = "Last name is mandatory")
    @Size(max = 20, message = "Last name must be less than 20 characters")
    private String lastName;
    private Set<String> roles;
    @Size(max = 40)
    private String street;
    @Size(max = 40)
    private String city;
    @Size(max = 40)
    private String state;
    @Size(max = 10)
    private String zipcode;
    @CreatedDate
    private Date createdAt;
    private boolean isActive = true;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
