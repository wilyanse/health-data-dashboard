USE health_db;

CREATE TABLE IF NOT EXISTS biometrics (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE,
    group_name VARCHAR(255),
    metric VARCHAR(255),
    unit VARCHAR(50),
    amount DECIMAL(10, 2)
);