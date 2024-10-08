package com.seek.candidatemanagement.application.dto.candidate;

import java.math.BigDecimal;

public class CandidateRequest {
    private Long id;
    private String name;
    private String email;
    private String gender;
    private BigDecimal salaryExpected;

    public CandidateRequest() {
    }

    public CandidateRequest(String name, String email, String gender, BigDecimal salaryExpected) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.salaryExpected = salaryExpected;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BigDecimal getSalaryExpected() {
        return salaryExpected;
    }

    public void setSalaryExpected(BigDecimal salaryExpected) {
        this.salaryExpected = salaryExpected;
    }

    @Override
    public String toString() {
        return "CandidateRequest [id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender
                + ", salaryExpected=" + salaryExpected + "]";
    }
}
