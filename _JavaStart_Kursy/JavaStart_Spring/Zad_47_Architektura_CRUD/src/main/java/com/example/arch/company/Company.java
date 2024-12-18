package com.example.arch.company;

import com.example.arch.joboffer.JobOffer;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String city;
    private Integer employees;
    private String telephone;
    private String email;
    // "cascade = CascadeType.REMOVE" oznacza, że jak ktoś usunie
    // firmę to razem z nią jej oferty pracy (jeżeli były)
    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
    private List<JobOffer> jobOfferList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<JobOffer> getJobOfferList() {
        return jobOfferList;
    }

    public void setJobOfferList(List<JobOffer> jobOfferList) {
        this.jobOfferList = jobOfferList;
    }
}
