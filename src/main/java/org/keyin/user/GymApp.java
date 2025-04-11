package org.keyin.user;

import org.keyin.user.childclasses.Admin;
import org.keyin.user.childclasses.Member;
import org.keyin.user.childclasses.Trainer;
import org.keyin.memberships.Membership;
import org.keyin.memberships.MembershipService;
import org.keyin.workoutclasses.WorkoutClass;
import org.keyin.workoutclasses.WorkoutClassService;

import java.sql.SQLException;
import java.util.Scanner;

public class GymApp {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();
        MembershipService membershipService = new MembershipService();
        WorkoutClassService workoutService = new WorkoutClassService();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Gym Management System ===");
            System.out.println("1. Add a new user");
            System.out.println("2. Login as a user");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewUser(scanner, userService);
                    break;
                case 2:
                    logInAsUser(scanner, userService, membershipService, workoutService);
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void logInAsUser(Scanner scanner, UserService userService, MembershipService membershipService, WorkoutClassService workoutService) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try {
            User user = userService.loginUser(username, password);
            if (user != null) {
                System.out.println("Login Successful! Welcome " + user.getUsername());
                switch (user.getRole().toLowerCase()) {
                    case "admin":
                        showAdminMenu(scanner, user, userService, membershipService, workoutService);
                        break;
                    case "trainer":
                        showTrainerMenu(scanner, user, userService, workoutService);
                        break;
                    case "member":
                        showMemberMenu(scanner, user, userService, membershipService);
                        break;
                    default:
                        System.out.println("Unknown role!");
                }
            } else {
                System.out.println("Login Failed! Invalid credentials.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while logging in.");
            e.printStackTrace();
        }
    }

    private static void showAdminMenu(Scanner scanner, User user, UserService userService, MembershipService membershipService, WorkoutClassService workoutService) {
        
        if (user instanceof Admin) {
            ((Admin) user).printAdminDashboard();
        }

        int choice;
        do {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View all users");
            System.out.println("2. Delete user");
            System.out.println("3. View all memberships");
            System.out.println("4. View total revenue");
            System.out.println("0. Logout");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    userService.viewAllUsers();
                    break;
                case 2:
                    System.out.print("Enter user ID to delete: ");
                    int userId = scanner.nextInt();
                    userService.deleteUser(userId);
                    break;
                case 3:
                    membershipService.listAllMemberships();
                    break;
                case 4:
                    membershipService.showTotalRevenue();
                    break;
                case 0:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void showTrainerMenu(Scanner scanner, User user, UserService userService, WorkoutClassService workoutService) {
        
        if (user instanceof Trainer) {
            ((Trainer) user).printTrainerProfile();
        }

        int choice;
        do {
            System.out.println("\n--- Trainer Menu ---");
            System.out.println("1. Add workout class");
            System.out.println("2. View all workout classes");
            System.out.println("3. Delete workout class");
            System.out.println("0. Logout");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter class ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter class type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String desc = scanner.nextLine();
                    workoutService.addClass(new WorkoutClass(id, type, desc, user.getId()));
                    break;
                case 2:
                    workoutService.showAllClasses();
                    break;
                case 3:
                    System.out.print("Enter class ID to delete: ");
                    int deleteId = scanner.nextInt();
                    workoutService.deleteClass(deleteId);
                    break;
                case 0:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void showMemberMenu(Scanner scanner, User user, UserService userService, MembershipService membershipService) {

        if (user instanceof Member) {
            ((Member) user).printMembershipSummary();
        }

        int choice;
        do {
            System.out.println("\n--- Member Menu ---");
            System.out.println("1. View all workout classes");
            System.out.println("2. Purchase membership");
            System.out.println("0. Logout");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    new WorkoutClassService().showAllClasses();
                    break;
                case 2:
                    System.out.print("Enter membership ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter cost: ");
                    double cost = scanner.nextDouble();
                    membershipService.purchaseMembership(new Membership(id, type, desc, cost, user.getId()));
                    break;
                case 0:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void addNewUser(Scanner scanner, UserService userService) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role (Admin/Trainer/Member): ");
        String role = scanner.nextLine();

        User user;
        switch (role.toLowerCase()) {
            case "admin":
                user = new Admin(0, username, password, "", "", "");
                break;
            case "trainer":
                user = new Trainer(0, username, password, "", "", "");
                break;
            case "member":
                user = new Member(0, username, password, "", "", "");
                break;
            default:
                System.out.println("Invalid role! User not created.");
                return;
        }

        userService.registerUser(user);
        System.out.println("User added successfully!");
    }
}