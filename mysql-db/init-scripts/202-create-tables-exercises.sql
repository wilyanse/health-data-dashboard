use health_db;

CREATE TABLE IF NOT EXISTS exercises (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE,
    group_name VARCHAR(255),
    exercise_name VARCHAR(255),
    minutes DECIMAL(10, 2),
    calories_burned DECIMAL(10, 2)
);