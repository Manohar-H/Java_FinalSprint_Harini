# Gym Management System
**Final Sprint – Winter 2025 | Solo Project by Harini Manohar

---

## 1️⃣ User Documentation

### Overview
This is a **console-based Gym Management System** built in Java using Maven and PostgreSQL. It allows three types of users — **Admin**, **Trainer**, and **Member** — to interact with the system based on their roles.

### Features
- Secure User Registration and Login (with BCrypt hashed passwords)
- Role-Based Access and Menus
- Membership Management for Members & Trainers
- Workout Class Scheduling and Management for Trainers
- Revenue Tracking for Admins

### How It Works
- Users can register as a Member, Trainer, or Admin.
- Passwords are hashed before being stored in the database.
- Each role has its own menu with relevant options.
- Data is stored and retrieved using JDBC with PostgreSQL.

### How To Use
1. Launch the application from your IDE or terminal.
2. Choose to register a new user or log in.
3. Based on your role, navigate through options using numeric input.

---

### Class Overview
- `User`, `Admin`, `Trainer`, `Member` — role-based user classes
- `UserService`, `UserDao` — manage login and registration
- `Membership`, `MembershipService`, `MembershipDao` — manage gym memberships
- `WorkoutClass`, `WorkoutClassService`, `WorkoutClassDao` — manage gym classes
- `GymApp` — Main class with menus

### Class diagram: 
<pre>
                      +------------------+
                      |      User        |  &lt;-- abstract
                      +------------------+
                      | id               |
                      | username         |
                      | password         |
                      | email            |
                      | phoneNumber      |
                      | address          |
                      | role             |
                      +------------------+
                               ▲
        ┌──────────────────────┼──────────────────────┐
        │                      │                      │
+---------------+     +----------------+       +-----------------+
|     Admin     |     |     Trainer    |       |     Member      |
+---------------+     +----------------+       +-----------------+
| printDashboard()    | assignedClassIds       | totalCost       |
|                     | printTrainerProfile()  | printSummary()  |

+--------------------+         +----------------------+
|   Membership       |         |  WorkoutClass        |
+--------------------+         +----------------------+
| id                 |         | id                   |
| type               |         | type                 |
| description        |         | description          |
| cost               |         | trainerId            |
| memberId           |         +----------------------+

+--------------------+         +----------------------+
|  UserService       |         |  MembershipService   |
+--------------------+         +----------------------+
| registerUser()     |         | purchaseMembership() |
| loginUser()        |         | listAllMemberships() |
+--------------------+         +----------------------+

+--------------------+
| WorkoutClassService|
+--------------------+
| addClass()         |
| deleteClass()      |
| showAllClasses()   |
+--------------------+
</pre>


---

## 2️⃣ Development Documentation

### 🧪 Key Methods & Javadocs

All main classes include inline Javadoc comments for methods and fields, e.g.:
**
 * Handles user login using BCrypt.
 * @param username The entered username
 * @param password The raw password to verify
 * @return Logged-in User object if successful, null if not
 */
public User loginUser(String username, String password) { ... }

/**
 * Registers a new user with a hashed password and saves it to the database.
 * @param user The User object to register
 */
public void registerUser(User user) {
    ...
}

/**
 * Returns a list of all users currently in the database.
 * @return List of User objects
 */
public List<User> getAllUsers() {
    ...
}

All main methods in service, DAO, and model classes are fully documented using standard Javadoc format inside the source code.

### Build Process
	1.	Make sure you have Java 17+ and Maven installed
	2.	Run:
            mvn clean install
            mvn exec:java -Dexec.mainClass="org.keyin.GymApp"

### Dependencies
	•	org.mindrot.jbcrypt — password hashing
	•	PostgreSQL JDBC Driver — database connectivity
	•	Maven — build and dependency management

### Database Setup
Create the following tables in PostgreSQL:
    CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    user_name VARCHAR(50),
    user_password VARCHAR(255),
    user_email VARCHAR(100),
    user_phonenumber VARCHAR(20),
    user_address VARCHAR(255),
    user_role VARCHAR(20)
    );

    CREATE TABLE memberships (
        membership_id SERIAL PRIMARY KEY,
        membership_type VARCHAR(50),
        membership_description TEXT,
        membership_cost DECIMAL(10,2),
        member_id INT
    );

    CREATE TABLE workout_classes (
        workoutclass_id SERIAL PRIMARY KEY,
        workoutclass_type VARCHAR(50),
        workoutclass_description TEXT,
        trainer_id INT
    );

📄 Full schema script available in [schema.sql](schema.sql)

### Cloning and Running
git clone https://github.com/Manohar-H/Java_FinalSprint_Harini.git
cd Java_FinalSprint_Harini
mvn clean install
mvn exec:java -Dexec.mainClass="org.keyin.GymApp"

## 3️⃣ Individual Report

My Contributions:
As a solo developer, I worked on:
	•	All feature branches: UserService, UserDao, WorkoutClass, Membership, and GymAppIntegration
	•	Full UI design for console menus
	•	Integration of PostgreSQL with DAO layer
	•	GitHub project structure and branch management

Challenges I Faced:
	•	Handling Maven and dependency resolution initially on Mac
	•	Implementing secure authentication with BCrypt
	•	Managing multiple role-based menus without clutter
	•	Ensuring correct file structure and project compilation

⸻

Thank you for reviewing my project!