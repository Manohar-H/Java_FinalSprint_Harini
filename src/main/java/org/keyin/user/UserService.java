package org.keyin.user;

import org.keyin.user.childclasses.Admin;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class UserService {

    private final UserDao userDao = new UserDao();

    public void registerUser(User user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        userDao.addUser(user);
        System.out.println("User registered successfully ✅");
    }

    public User loginUser(String username, String password) {
        try {
            User user = userDao.getUserByUsername(username);
            if (user == null) {
                System.out.println("❌ User not found.");
                return null;
            }

            if (BCrypt.checkpw(password.trim(), user.getPassword().trim())) {
                return user;
            } else {
                System.out.println("❌ Invalid password.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while logging in.");
        }

        return null;
    }

    public void viewAllUsers() {
        for (User user : userDao.getAllUsers()) {
            System.out.println(user);
        }
    }

    public void deleteUser(int id) {
        userDao.deleteUserById(id);
        System.out.println("User deleted successfully ❗");
    }

    public void testHashMatch() {
        String rawPassword = "adminpass";
        String storedHash = "$2a$12$mtEKS30NSQkkgUR0wAqvIuHDLTrXsjSkpZrxzfxULVRuUg31Q9qHa";
        boolean match = BCrypt.checkpw(rawPassword, storedHash);
        System.out.println("Password matches hash? " + match);
    }

    public void insertAdminHardcoded() {
        Admin admin = new Admin(
            0,
            "admin1",
            BCrypt.hashpw("adminpass", BCrypt.gensalt()),
            "admin@gym.com",
            "1234567890",
            "1 Admin St"
        );
        admin.setRole("admin");
    
        try {
            userDao.addUser(admin);
            System.out.println("✅ Admin inserted programmatically with hashed password.");
        } catch (Exception e) {
            System.out.println("❌ Failed to insert admin user.");
            e.printStackTrace();
        }
    }
}