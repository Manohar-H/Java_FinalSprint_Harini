-- User Table --

CREATE TABLE IF NOT EXISTS users (
    user_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY
    user_name VARCHAR(50),
    user_password VARCHAR(255),
    user_email VARCHAR(100),
    user_phonenumber VARCHAR(20),
    user_address VARCHAR(255),
    user_role VARCHAR(20)
);

-- Membership Table --

CREATE TABLE IF NOT EXISTS memberships (
    membership_id SERIAL PRIMARY KEY,
    membership_type VARCHAR(50),
    membership_description TEXT,
    membership_cost DECIMAL(10,2),
    member_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY
);

-- Workout Class Table --

CREATE TABLE IF NOT EXISTS workout_classes (
    workoutclass_id SERIAL PRIMARY KEY,
    workoutclass_type VARCHAR(50),
    workoutclass_description TEXT,
    trainer_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY
);


-- Sample Memberships --

INSERT INTO memberships (membership_type, membership_description, membership_cost, member_id)
VALUES
('Monthly', 'Basic gym access', 49.99, 3),
('Yearly', 'All-access VIP membership', 499.99, 3);

-- Sample Workout Classes --

INSERT INTO workout_classes (workoutclass_type, workoutclass_description, trainer_id)
VALUES
('Yoga', 'Morning yoga for flexibility', 2),
('HIIT', 'High intensity interval training', 2);