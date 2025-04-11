-- User Table
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    user_name VARCHAR(50),
    user_password VARCHAR(255),
    user_email VARCHAR(100),
    user_phonenumber VARCHAR(20),
    user_address VARCHAR(255),
    user_role VARCHAR(20)
);

-- Membership Table
CREATE TABLE memberships (
    membership_id SERIAL PRIMARY KEY,
    membership_type VARCHAR(50),
    membership_description TEXT,
    membership_cost DECIMAL(10,2),
    member_id INT
);

-- Workout Class Table
CREATE TABLE workout_classes (
    workoutclass_id SERIAL PRIMARY KEY,
    workoutclass_type VARCHAR(50),
    workoutclass_description TEXT,
    trainer_id INT
);


INSERT INTO users (user_name, user_password, user_email, user_phonenumber, user_address, user_role)
VALUES ('admin1', 'password123', 'admin@gym.com', '1234567890', '123 Admin St', 'admin');