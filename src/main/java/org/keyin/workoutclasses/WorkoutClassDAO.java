package org.keyin.workoutclasses;

import org.keyin.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkoutClassDAO {

    public void addWorkoutClass(WorkoutClass workoutClass) {
        String sql = "INSERT INTO workout_classes (workoutclass_id, workoutclass_type, workoutclass_description, trainer_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, workoutClass.getId());
            pstmt.setString(2, workoutClass.getType());
            pstmt.setString(3, workoutClass.getDescription());
            pstmt.setInt(4, workoutClass.getTrainerId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<WorkoutClass> getAllWorkoutClasses() {
        List<WorkoutClass> workoutClasses = new ArrayList<>();
        String sql = "SELECT * FROM workout_classes";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                workoutClasses.add(new WorkoutClass(
                        rs.getInt("workoutclass_id"),
                        rs.getString("workoutclass_type"),
                        rs.getString("workoutclass_description"),
                        rs.getInt("trainer_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workoutClasses;
    }

    public void deleteWorkoutClassById(int id) {
        String sql = "DELETE FROM workout_classes WHERE workoutclass_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}