package com.seek.candidatemanagement.domain.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seek.candidatemanagement.application.dto.candidate.CandidateRequest;
import com.seek.candidatemanagement.application.dto.candidate.CandidateResponse;
import com.seek.candidatemanagement.application.mapper.CandidateMapper;
import com.seek.candidatemanagement.domain.model.Candidate;
import com.seek.candidatemanagement.domain.model.RecruitmentStatus;
import com.seek.candidatemanagement.domain.repository.CandidateRepository;
import com.seek.candidatemanagement.domain.service.ICandidateService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CandidateServiceImpl implements ICandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public List<CandidateResponse> findAll() {
        // Obtiene la lista de candidatos
        List<Candidate> candidates = candidateRepository.findAll();

        // Mapea y trasforma el listado usando el CandidateMapper
        return candidates.stream()
                         .map(CandidateMapper::toDto)
                         .collect(Collectors.toList());
    }

    @Override
    public CandidateResponse findById(Long id) {
        // Busca la entidad Candidate por ID
        Optional<Candidate> candidateOptional = candidateRepository.findById(id);

        // Valida la existencia del candidato
        if (!candidateOptional.isPresent()) {
            throw new EntityNotFoundException("Candidate not found with ID: " + id);
        }

        // Mapea la entidad Candidate a CandidateResponse usando el CandidateMapper
        return CandidateMapper.toDto(candidateOptional.get());
    }

    @Override
    public CandidateResponse create(CandidateRequest request) {
        // Mapea el DTO CandidateRequest a la entidad Candidate usando el CandidateMapper
        Candidate candidate = CandidateMapper.toEntity(request);

        // Completa los campos adicionales que no vienen en el request
        candidate.setApplicationDate(LocalDate.now());
        candidate.setRecruitmentStatus(RecruitmentStatus.APPLIED);

        // Guarda la entidad en la base de datos
        candidateRepository.save(candidate);

        // Mapea la entidad Candidate a CandidateResponse usando el CandidateMapper
        return CandidateMapper.toDto(candidate);
    }

    @Override
    public CandidateResponse update(CandidateRequest request) {
        // Busca la entidad Candidate por ID
        Optional<Candidate> candidateOptional = candidateRepository.findById(request.getId());

        // Valida la existencia del candidato
        if (!candidateOptional.isPresent()) {
            throw new EntityNotFoundException("Candidate not found with ID: " + request.getId());
        }

        // Mapea el DTO CandidateRequest a la entidad Candidate usando el CandidateMapper
        Candidate candidate = CandidateMapper.toEntity(request);
        candidate.setApplicationDate(candidateOptional.get().getApplicationDate());
        candidate.setRecruitmentStatus(candidateOptional.get().getRecruitmentStatus());

        // Guarda la entidad en la base de datos
        candidateRepository.save(candidate);

        // Mapea la entidad Candidate a CandidateResponse usando el CandidateMapper
        return CandidateMapper.toDto(candidate);
    }


    @Override
    public CandidateResponse updateRecruitmentStatus(Long candidateId, RecruitmentStatus newStatus) {
        Optional<Candidate> candidateOptional = candidateRepository.findById(candidateId);
        
        // Valida la existencia del candidato
        if (!candidateOptional.isPresent()) {
            throw new EntityNotFoundException("Candidate not found with ID: " + candidateId);
        }        
        
        // Asigna el nuevo estado
        Candidate candidate = candidateOptional.get();
        candidate.setRecruitmentStatus(newStatus);

        // Guarda la entidad en la base de datos
        candidateRepository.save(candidate);

        // Mapea la entidad Candidate a CandidateResponse usando el CandidateMapper
        return CandidateMapper.toDto(candidate);
    }

    @Override
    public void delete(Long id) {
        // Busca la entidad Candidate por ID
        Optional<Candidate> candidateOptional = candidateRepository.findById(id);

        // Valida la existencia del candidato
        if (!candidateOptional.isPresent()) {
            throw new EntityNotFoundException("Candidate not found with ID: " + id);
        }

        // Elimina la entidad de la base de datos
        candidateRepository.deleteById(id);
    }

}
