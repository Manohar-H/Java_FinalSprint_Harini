package org.keyin.user.childclasses;

import org.keyin.user.User;

public class Admin extends User {

    public Admin(int id, String username, String password, String email, String phoneNumber, String address) {
        super(id, username, password, email, phoneNumber, address, "Admin");
    }

    public void printAdminDashboard() {
        System.out.println("🛡️ Admin Dashboard Accessed");
        System.out.println("Welcome, " + getUsername());
    }
}