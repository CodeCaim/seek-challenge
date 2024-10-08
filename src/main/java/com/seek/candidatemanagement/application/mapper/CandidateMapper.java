package com.seek.candidatemanagement.application.mapper;

import com.seek.candidatemanagement.application.dto.candidate.CandidateRequest;
import com.seek.candidatemanagement.application.dto.candidate.CandidateResponse;
import com.seek.candidatemanagement.domain.model.Candidate;

public class CandidateMapper {

    // Convertir de Entity a DTO
    public static CandidateResponse toDto(Candidate candidate) {
        CandidateResponse response = new CandidateResponse();
        response.setId(candidate.getId());
        response.setName(candidate.getName());
        response.setEmail(candidate.getEmail());
        response.setGender(candidate.getGender());
        response.setSalaryExpected(candidate.getSalaryExpected());
        response.setApplicationDate(candidate.getApplicationDate());
        response.setRecruitmentStatus(candidate.getRecruitmentStatus().name());
        return response;
    }

    // Convertir de DTO a Entity
    public static Candidate toEntity(CandidateRequest request) {
        return Candidate.builder()
            .id(request.getId())
            .name(request.getName())
            .email(request.getEmail())
            .gender(request.getGender())
            .salaryExpected(request.getSalaryExpected())
            .build();
    }
}
