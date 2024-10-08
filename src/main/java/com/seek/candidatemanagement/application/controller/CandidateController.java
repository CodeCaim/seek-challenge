package com.seek.candidatemanagement.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seek.candidatemanagement.application.dto.candidate.CandidateRequest;
import com.seek.candidatemanagement.application.dto.candidate.CandidateResponse;
import com.seek.candidatemanagement.application.dto.candidate.UpdateCandidateStatusRequest;
import com.seek.candidatemanagement.domain.service.ICandidateService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateController {
    
    @Autowired
    private ICandidateService candidateService;

    @Operation(summary = "Get a list of all candidates")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved the list"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public ResponseEntity<List<CandidateResponse>> getAllCandidates() {

        List<CandidateResponse> candidates = candidateService.findAll();
        return ResponseEntity.ok(candidates);
    }


    @Operation(summary = "Get a candidate by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved the candidate"),
        @ApiResponse(responseCode = "404", description = "Candidate not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CandidateResponse> getCandidateById(
        @Parameter(description = "ID of the candidate to retrieve", required = true)
        @PathVariable Long id) {

        CandidateResponse candidate = candidateService.findById(id);
        return ResponseEntity.ok(candidate);
    }


    @Operation(summary = "Create a new candidate")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Candidate successfully created"),
        @ApiResponse(responseCode = "400", description = "Bad request, check the input data")
    })
    @PostMapping
    public ResponseEntity<CandidateResponse> createCandidate(
        @Parameter(description = "Details of the new candidate", required = true)        
        @RequestBody CandidateRequest candidate) {
            
        CandidateResponse newCandidate = candidateService.create(candidate);
        return new ResponseEntity<>(newCandidate, HttpStatus.CREATED);
    }


    @Operation(summary = "Update a candidate by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Candidate updated"),
        @ApiResponse(responseCode = "404", description = "Candidate not found"),
        @ApiResponse(responseCode = "400", description = "Bad request, check the input data")
    })
    @PutMapping("/{id}")
    public ResponseEntity<CandidateResponse> updateCandidate(
        @Parameter(description = "ID of the candidate to update", required = true)
        @PathVariable Long id, 
        @Parameter(description = "Updated details of the candidate", required = true)
        @RequestBody CandidateRequest candidate) {

        candidate.setId(id);
        CandidateResponse updatedCandidate = candidateService.update(candidate);
        return ResponseEntity.ok(updatedCandidate);
    }


    @Operation(summary = "Update the status of a candidate")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Candidate status updated"),
        @ApiResponse(responseCode = "404", description = "Candidate not found"),
        @ApiResponse(responseCode = "400", description = "Invalid status update")
    })
    @PutMapping("/{id}/status")
    public ResponseEntity<CandidateResponse> updateCandidateStatus(
        @Parameter(description = "ID of the candidate to update", required = true)
        @PathVariable Long id, 
        @Parameter(description = "New status for the candidate", required = true)
        @RequestBody UpdateCandidateStatusRequest request) {

        CandidateResponse updatedCandidate = candidateService.updateRecruitmentStatus(id, request.getRecruitmentStatus());
        return ResponseEntity.ok(updatedCandidate);
    }


    @Operation(summary = "Delete a candidate by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Candidate deleted"),
        @ApiResponse(responseCode = "404", description = "Candidate not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(
        @Parameter(description = "ID of the candidate to delete", required = true)
        @PathVariable Long id) {

        candidateService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
