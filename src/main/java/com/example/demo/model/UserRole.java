package com.example.demo.model;

public enum UserRole {
    FUNCIONARIO("funcionario"),
    EMPRESA("empresa"),
    PROPRIETARIO("proprietario");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}