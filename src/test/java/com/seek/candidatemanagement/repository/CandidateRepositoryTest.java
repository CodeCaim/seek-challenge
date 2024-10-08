package com.seek.candidatemanagement.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.seek.candidatemanagement.domain.model.Candidate;
import com.seek.candidatemanagement.domain.model.RecruitmentStatus;
import com.seek.candidatemanagement.domain.repository.CandidateRepository;

@SpringBootTest
@ActiveProfiles("test") 
public class CandidateRepositoryTest {

    @Autowired
    private CandidateRepository candidateRepository;

    @Test
    public void testSaveAndFindCandidate() {
        // Crea un candidato y lo guarda en la base de datos
        Candidate candidate = new Candidate(null, "John Doe", "john.doe@example.com", "Male", new BigDecimal("60000"), LocalDate.now(), RecruitmentStatus.APPLIED);
        Candidate savedCandidate = candidateRepository.save(candidate);

        // Verifica que el candidato guardado tenga un ID asignado
        assertNotNull(savedCandidate.getId());

        // Verifica que el candidato pueda ser encontrado por su ID
        Optional<Candidate> foundCandidate = candidateRepository.findById(savedCandidate.getId());
        assertTrue(foundCandidate.isPresent());
        assertEquals("John Doe", foundCandidate.get().getName());
    }

    @Test
    public void testFindAllCandidates() {
        // Guarda dos candidatos en la base de datos
        Candidate candidate1 = new Candidate(null, "John Doe", "john.doe@example.com", "Male", new BigDecimal("60000"), LocalDate.now(), RecruitmentStatus.APPLIED);
        Candidate candidate2 = new Candidate(null, "Jane Smith", "jane.smith@example.com", "Female", new BigDecimal("70000"), LocalDate.now(), RecruitmentStatus.INTERVIEW);
        candidateRepository.save(candidate1);
        candidateRepository.save(candidate2);

        // Verifica que findAll devuelve ambos candidatos, incluyendo el registro generado en el test anterior (testSaveAndFindCandidate)
        List<Candidate> candidates = candidateRepository.findAll();
        assertEquals(3, candidates.size());
    }
}
