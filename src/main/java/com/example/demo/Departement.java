package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToMany(mappedBy = "departements", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<Employee> employees;

    public long getId() {
        return id;
    }
    public Departement(){

    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
