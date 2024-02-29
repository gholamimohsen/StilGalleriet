package com.project.stilgalleriet.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class Role {
    @Id
    private String id;

    private ERole rolePermission; // Hanterar om man är User eller en Admin.

    public Role() {
    }

    public Role(ERole rolePermission) {
        this.rolePermission = rolePermission;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ERole getRolePermission() {
        return rolePermission;
    }

    public void setRolePermission(ERole rolePermission) {
        this.rolePermission = rolePermission;
    }
}
