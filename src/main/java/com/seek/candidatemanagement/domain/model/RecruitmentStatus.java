package com.seek.candidatemanagement.domain.model;

public enum RecruitmentStatus {
    APPLIED, // El candidato ha enviado su solicitud.
    INTERVIEW, //El candidato está en la fase de entrevistas.
    OFFERED, // Se ha hecho una oferta al candidato.
    REJECTED, // El candidato ha sido rechazado.
    HIRED, // El candidato ha sido contratado.
    ON_HOLD, // El proceso de selección del candidato está en pausa.
    ASSESSMENT, // El candidato está en fase de evaluación (tests técnicos o pruebas).
    WITHDRAWN, // El candidato ha retirado su postulación.
    BACKGROUND_CHECK // El candidato está en proceso de verificación de antecedentes.
}
