package com.seek.candidatemanagement.domain.service;

import java.util.List;

import com.seek.candidatemanagement.application.dto.candidate.CandidateRequest;
import com.seek.candidatemanagement.application.dto.candidate.CandidateResponse;
import com.seek.candidatemanagement.domain.model.RecruitmentStatus;

public interface ICandidateService {
    List<CandidateResponse> findAll();
    CandidateResponse findById(Long id);
    CandidateResponse create(CandidateRequest candidate);
    CandidateResponse update(CandidateRequest candidate);
    CandidateResponse updateRecruitmentStatus(Long candidateId, RecruitmentStatus newStatus);
    void delete(Long id);    
}
