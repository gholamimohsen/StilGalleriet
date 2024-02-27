package com.project.stilgalleriet.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "User")
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



}
