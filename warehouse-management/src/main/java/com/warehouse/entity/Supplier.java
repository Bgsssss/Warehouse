package com.warehouse.entity;

public class Supplier {
    
    String supplierId;

    String name;

    String email;

    String contactPerson;
    
    public Supplier() {
    }

    public Supplier(String supplierID, String name, String email, String contactPerson) {
        this.supplierId = supplierID;
        this.name = name;
        this.email = email;
        this.contactPerson = contactPerson;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierID) {
        this.supplierId = supplierID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    
}
