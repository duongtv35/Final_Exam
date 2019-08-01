package com.codegym.cms.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany
    private Set<City> cities;

    public Country(String name, Set<City> cities) {
        this.name = name;
        this.cities = cities;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public Country(String name) {
        this.name = name;
    }

    public Country() {
    }

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
}
