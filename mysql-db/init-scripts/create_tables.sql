CREATE DATABASE IF NOT EXISTS health_db;

USE health_db;

CREATE TABLE IF NOT EXISTS biometrics (
    id INT AUTO_INCREMENT PRIMARY KEY,
    day DATE,
    group_name VARCHAR(255),
    metric VARCHAR(255),
    unit VARCHAR(50),
    amount DECIMAL(10, 2)
);

-- Insert example record
INSERT INTO biometrics (day, group_name, metric, unit, amount) VALUES 
('2024-03-19', 'Uncategorized', 'Weight', 'kg', 93.5);