package org.keyin.user.childclasses;

import org.keyin.user.User;

public class Member extends User {

    private double totalMembershipCost = 0.0;

    public Member(int id, String username, String password, String email, String phoneNumber, String address) {
        super(id, username, password, email, phoneNumber, address, "Member");
    }

    public void addToMembershipCost(double amount) {
        totalMembershipCost += amount;
    }

    public double getTotalMembershipCost() {
        return totalMembershipCost;
    }

    public void printMembershipSummary() {
        System.out.println("🧾 Membership Summary for " + getUsername());
        System.out.println("Total Spent on Memberships: $" + totalMembershipCost);
    }
}