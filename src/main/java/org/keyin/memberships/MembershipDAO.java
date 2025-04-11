package org.keyin.memberships;

import org.keyin.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembershipDAO {

    public void addMembership(Membership membership) {
        String sql = "INSERT INTO memberships (membership_id, membership_type, membership_description, membership_cost, member_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, membership.getId());
            pstmt.setString(2, membership.getType());
            pstmt.setString(3, membership.getDescription());
            pstmt.setDouble(4, membership.getCost());
            pstmt.setInt(5, membership.getMemberId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Membership> getAllMemberships() {
        List<Membership> memberships = new ArrayList<>();
        String sql = "SELECT * FROM memberships";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                memberships.add(new Membership(
                        rs.getInt("membership_id"),
                        rs.getString("membership_type"),
                        rs.getString("membership_description"),
                        rs.getDouble("membership_cost"),
                        rs.getInt("member_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memberships;
    }

    public double getTotalRevenue() {
        String sql = "SELECT SUM(membership_cost) AS total FROM memberships";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}