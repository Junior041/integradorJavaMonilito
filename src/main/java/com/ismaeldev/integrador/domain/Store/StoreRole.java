package com.ismaeldev.integrador.domain.Store;

public enum StoreRole {

    ADMIN("admin"),
    USER("user");

    private final String role;

    StoreRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

}
