package com.zipcodewilmington.bakery.models;


public class Baker {
    private Long id;

    private String name;

    private String employeeId;

    private String specialty;

    public Baker() {
    }

    public Baker(String name, String employeeId, String specialty) {
        this(null, name, employeeId, specialty);
    }

    public Baker(Long id, String name, String employeeId, String specialty) {
        this.id = id;
        this.name = name;
        this.employeeId = employeeId;
        this.specialty = specialty;
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

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
