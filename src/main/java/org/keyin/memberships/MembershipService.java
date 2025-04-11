package org.keyin.memberships;

import java.util.List;

public class MembershipService {

    private final MembershipDAO membershipDAO = new MembershipDAO();

    public void purchaseMembership(Membership membership) {
        membershipDAO.addMembership(membership);
        System.out.println("✅ Membership purchased!");
    }

    public void listAllMemberships() {
        List<Membership> memberships = membershipDAO.getAllMemberships();
        for (Membership m : memberships) {
            System.out.println(m);
        }
    }

    public void showTotalRevenue() {
        double revenue = membershipDAO.getTotalRevenue();
        System.out.println("💰 Total revenue: $" + revenue);
    }
}