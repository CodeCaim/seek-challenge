-- V1__Tablas.sql

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(20) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    firstname VARCHAR(50),
    country VARCHAR(50),
    password VARCHAR(255) NOT NULL,
    role VARCHAR(10)
);

CREATE TABLE candidates (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    gender VARCHAR(10),
    salary_expected DECIMAL(10, 2),
    application_date DATETIME,
    recruitment_status VARCHAR(10) NOT NULL
);
