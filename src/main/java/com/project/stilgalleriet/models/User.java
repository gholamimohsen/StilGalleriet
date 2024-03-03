package com.project.stilgalleriet.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
public class User {
   @Id
   private String id;
   @DBRef
   private Set<Role> roles = new HashSet<>();
   private String firstName;
   private String lastName;
   private String email;
   private String password;
   private ArrayList address;
   private Enum role;
   private boolean isActive;
   private ArrayList favorites;
   private String advertisementId;


   public User() {
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
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

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public ArrayList getAddress() {
      return address;
   }

   public void setAddress(ArrayList adress) {
      this.address = adress;
   }

   public Enum getRole() {
      return role;
   }

   public void setRole(Enum role) {
      this.role = role;
   }

   public boolean isActive() {
      return isActive;
   }

   public void setActive(boolean active) {
      isActive = active;
   }

   public ArrayList getFavorites() {
      return favorites;
   }

   public void setFavorites(ArrayList favorites) {
      this.favorites = favorites;
   }

   public String getAdvertisementId() {
      return advertisementId;
   }

   public void setAdvertisementId(String advertisementId) {
      this.advertisementId = advertisementId;
   }
}
