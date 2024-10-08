-- V2__Inserts.sql

INSERT INTO users (username, lastname, firstname, country, password, role)
VALUES
('admin', 'Infantas', 'Carlos', 'Perú', '$2a$10$cAB73c1mXSy68m2WLVHtNO/YobZEY7fSBx5.0aOyCOolSNk7MPj/G', 'ADMIN');

INSERT INTO candidates (name, email, gender, salary_expected, application_date, recruitment_status)
VALUES
('John Doe', 'john.doe@example.com', 'Male', 60000, '2024-10-01', 'APPLIED'),
('Jane Smith', 'jane.smith@example.com', 'Female', 70000, '2024-10-02', 'INTERVIEW'),
('Bill Gates', 'bill.gates@example.com', 'Male', 90000, '2024-09-29', 'OFFERED'),
('Sara Connor', 'sara.connor@example.com', 'Female', 65000, '2024-09-30', 'APPLIED'),
('Elon Musk', 'elon.musk@example.com', 'Male', 100000, '2024-09-28', 'REJECTED');
