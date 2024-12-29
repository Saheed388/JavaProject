package com.saheed.JobApp.company;

import jakarta.persistence.*;

@Entity
@Table(name = "CompanyTable")

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String companyName;
    private String companyAddress;
    private String country;
    private String state;
    private String email;
    private String phoneNumber;
    private String websiteUrl;

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public Company(Long id, String companyName,
                   String companyAddress,
                   String country,
                   String state, String email,
                   String phoneNumber,
                   String websiteUrl) {
        this.id = id;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.country = country;
        this.state = state;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.websiteUrl = websiteUrl;
    }
}
