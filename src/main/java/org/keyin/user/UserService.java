package org.keyin.user;

import org.keyin.user.childclasses.Admin;
import org.keyin.user.childclasses.Member;
import org.keyin.user.childclasses.Trainer;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class UserService {

    private final UserDao userDao = new UserDao();

    public void registerUser(User user) {
        // Hash the password before saving
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        userDao.addUser(user);
        System.out.println("User registered successfully ✅");
    }

    public User loginUser(String username, String plainPassword) {
        try {
            User user = userDao.getUserByUsername(username);
            if (user == null) {
                System.out.println("❌ User not found.");
                return null;
            }

            if (BCrypt.checkpw(plainPassword, user.getPassword())) {
                System.out.println("✅ Login successful! Welcome, " + user.getUsername());
                return user;
            } else {
                System.out.println("❌ Invalid password.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
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
}