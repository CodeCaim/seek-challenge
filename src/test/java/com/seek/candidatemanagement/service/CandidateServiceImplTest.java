package com.seek.candidatemanagement.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.seek.candidatemanagement.application.dto.candidate.CandidateRequest;
import com.seek.candidatemanagement.application.dto.candidate.CandidateResponse;
import com.seek.candidatemanagement.application.mapper.CandidateMapper;
import com.seek.candidatemanagement.domain.model.Candidate;
import com.seek.candidatemanagement.domain.model.RecruitmentStatus;
import com.seek.candidatemanagement.domain.repository.CandidateRepository;
import com.seek.candidatemanagement.domain.service.impl.CandidateServiceImpl;

import jakarta.persistence.EntityNotFoundException;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class CandidateServiceImplTest {

    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private CandidateServiceImpl candidateService;

    @Test
    public void testFindAllCandidates() {
        // Dado que el repositorio devuelve una lista de candidatos
        List<Candidate> candidates =  Arrays.asList(
            new Candidate(1L, "John Doe", "john.doe@example.com", "Male", new BigDecimal("60000"), LocalDate.now(), RecruitmentStatus.APPLIED),
            new Candidate(2L, "Jane Smith", "jane.smith@example.com", "Female", new BigDecimal("70000"), LocalDate.now(), RecruitmentStatus.INTERVIEW)
        );

        Mockito.when(candidateRepository.findAll()).thenReturn(candidates);

        // Cuando el servicio llama a findAll
        List<CandidateResponse> result = candidateService.findAll();

        // Entonces se espera que el resultado tenga 2 candidatos
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testFindCandidateById() {
        // Dado que el repositorio devuelve un candidato
        Candidate candidate = new Candidate(1L, "John Doe", "john.doe@example.com", "Male", new BigDecimal(60000), LocalDate.now(), RecruitmentStatus.APPLIED);
        Mockito.when(candidateRepository.findById(1L)).thenReturn(Optional.of(candidate));

        // Cuando el servicio llama a findById
        CandidateResponse result = candidateService.findById(1L);

        // Entonces se espera que el candidato devuelto tenga el nombre "John Doe"
        assertEquals("John Doe", result.getName());
    }

    @Test
    public void testCreateCandidate() {
        // Dado que el repositorio guarda un candidato
        CandidateRequest request = new CandidateRequest("John Doe", "john.doe@example.com", "Male", new BigDecimal(60000));
        Candidate candidate = CandidateMapper.toEntity(request);
        candidate.setId(1L); // Se simula el ID generado por la BD
        
        Mockito.when(candidateRepository.save(Mockito.any(Candidate.class))).thenReturn(candidate);

        // Cuando el servicio llama a create
        CandidateResponse result = candidateService.create(request);

        // Entonces se espera que el candidato creado tenga el nombre "John Doe"
        assertEquals("John Doe", result.getName());
    }

    @Test
    public void testUpdateRecruitmentStatus() {
        // Dado que el repositorio devuelve un candidato existente
        Candidate candidate = new Candidate(1L, "John Doe", "john.doe@example.com", "Male", new BigDecimal(60000), LocalDate.now(), RecruitmentStatus.APPLIED);
        Mockito.when(candidateRepository.findById(1L)).thenReturn(Optional.of(candidate));

        // Cuando el servicio actualiza el estado del candidato
        CandidateResponse result = candidateService.updateRecruitmentStatus(1L, RecruitmentStatus.INTERVIEW);

        // Entonces se espera que el estado del candidato sea "INTERVIEW"
        assertEquals("INTERVIEW", result.getRecruitmentStatus());
    }

    @Test
    public void testUpdateRecruitmentStatusThrowsException() {
        // Simula que el candidato no se encuentra
        when(candidateRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Verifica que se lanza la excepción
        assertThrows(EntityNotFoundException.class, () -> {
            candidateService.updateRecruitmentStatus(1L, RecruitmentStatus.HIRED);
        });
    }

}

