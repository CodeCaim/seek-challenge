package com.seek.candidatemanagement.application.dto.candidate;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CandidateResponse {
    private Long id;
    private String name;
    private String email;
    private String gender;
    private BigDecimal salaryExpected;
    private LocalDate applicationDate;
    private String recruitmentStatus;

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

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getRecruitmentStatus() {
        return recruitmentStatus;
    }

    public void setRecruitmentStatus(String recruitmentStatus) {
        this.recruitmentStatus = recruitmentStatus;
    }
}
