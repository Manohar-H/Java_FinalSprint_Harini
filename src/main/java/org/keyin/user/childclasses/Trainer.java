package org.keyin.user.childclasses;

import org.keyin.user.User;

import java.util.ArrayList;
import java.util.List;

public class Trainer extends User {

    private List<Integer> assignedClassIds = new ArrayList<>();

    public Trainer(int id, String username, String password, String email, String phoneNumber, String address) {
        super(id, username, password, email, phoneNumber, address, "Trainer");
    }

    public void assignClass(int classId) {
        assignedClassIds.add(classId);
    }

    public List<Integer> getAssignedClassIds() {
        return assignedClassIds;
    }

    public void printTrainerProfile() {
        System.out.println("\nLogin Success.");
        System.out.println("Trainer: Hello, " + getUsername());
        System.out.println("\nChoose from the following options:");
    }
}