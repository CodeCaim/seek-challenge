package com.seek.candidatemanagement.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;
    
    private String gender;
    private BigDecimal salaryExpected;

    private LocalDate applicationDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RecruitmentStatus recruitmentStatus;

    public Candidate() {
    }

    public Candidate(Long id, String name, String email, String gender, BigDecimal salaryExpected, LocalDate applicationDate, RecruitmentStatus recruitmentStatus) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.salaryExpected = salaryExpected;
        this.applicationDate = applicationDate;
        this.recruitmentStatus = recruitmentStatus;
    }

    public static Candidate.CandidateBuilder builder() {
        return new Candidate.CandidateBuilder();
    }

    public static class CandidateBuilder {
        private Long id;
        private String name;
        private String email;
        private String gender;
        private BigDecimal salaryExpected;
        private LocalDate applicationDate;
        private RecruitmentStatus recruitmentStatus;

        public Candidate.CandidateBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public Candidate.CandidateBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Candidate.CandidateBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Candidate.CandidateBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Candidate.CandidateBuilder salaryExpected(BigDecimal salaryExpected) {
            this.salaryExpected = salaryExpected;
            return this;
        }

        public Candidate.CandidateBuilder applicationDate(LocalDate applicationDate) {
            this.applicationDate = applicationDate;
            return this;
        }

        public Candidate.CandidateBuilder recruitmentStatus(RecruitmentStatus recruitmentStatus) {
            this.recruitmentStatus = recruitmentStatus;
            return this;
        }

        public Candidate build() {
            return new Candidate(id, name, email, gender, salaryExpected, applicationDate, recruitmentStatus);
        }
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

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public RecruitmentStatus getRecruitmentStatus() {
        return recruitmentStatus;
    }

    public void setRecruitmentStatus(RecruitmentStatus recruitmentStatus) {
        this.recruitmentStatus = recruitmentStatus;
    }

    @Override
    public String toString() {
        return "Candidate [id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender
                + ", salaryExpected=" + salaryExpected + ", applicationDate=" + applicationDate
                + ", recruitmentStatus=" + recruitmentStatus + "]";
    }    
}
