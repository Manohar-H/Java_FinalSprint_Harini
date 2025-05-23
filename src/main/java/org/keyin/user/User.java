package org.keyin.user;

/**
 * Parent class for all users in Harini's Gym Management System.
 * Roles: Admin, Trainer, Member
 */
public abstract class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
    private String role;

    public User(int id, String username, String password, String email, String phoneNumber, String address, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role = role;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return String.format(
            "👤 User ID: %d\n🔑 Username: %s\n🎭 Role: %s\n📧 Email: %s\n📱 Phone: %s\n🏠 Address: %s\n",
            id,
            username,
            capitalize(role),
            email.isEmpty() ? "N/A" : email,
            phoneNumber.isEmpty() ? "N/A" : phoneNumber,
            address.isEmpty() ? "N/A" : address
        );
    }

    // Helper method
    private String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}