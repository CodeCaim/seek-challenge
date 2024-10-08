package com.seek.candidatemanagement.application.dto.candidate;

import com.seek.candidatemanagement.domain.model.RecruitmentStatus;

public class UpdateCandidateStatusRequest {
    private RecruitmentStatus recruitmentStatus;

    public RecruitmentStatus getRecruitmentStatus() {
        return recruitmentStatus;
    }

    public void setRecruitmentStatus(RecruitmentStatus recruitmentStatus) {
        this.recruitmentStatus = recruitmentStatus;
    }
}
