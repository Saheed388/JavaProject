package com.saheed.JobApp.jobs;

import com.saheed.JobApp.company.Company;
import jakarta.persistence.*;
import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name = "JobTable")

public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //used to generate unique id
    private  Long id;
    private  String title;
    private  String description;
    private  String minSalary;
    private  String maxSalary;
    private  String location;

    @JsonIgnore
    @ManyToOne
    private  Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


//Generate Consructor
// default no argument constructor for jpa to instatiate entity object
    public Job() {
    }

    public Job(Long id,
               String title,
               String description,
               String minSalary,
               String maxSalary,
               String location) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

// Generate Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
