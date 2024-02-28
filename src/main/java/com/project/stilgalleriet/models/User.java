package com.project.stilgalleriet.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "users")
public class User {
   @Id
   private String id;
   private String firstName;
   private String lastName;
   private String email;
   private String password;
   private ArrayList adress;
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

   public ArrayList getAdress() {
      return adress;
   }

   public void setAdress(ArrayList adress) {
      this.adress = adress;
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
