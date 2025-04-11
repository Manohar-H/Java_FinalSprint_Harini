package org.keyin.workoutclasses;

import java.util.List;

public class WorkoutClassService {

    private final WorkoutClassDAO dao = new WorkoutClassDAO();

    public void addClass(WorkoutClass workoutClass) {
        dao.addWorkoutClass(workoutClass);
        System.out.println("💪 Workout class added!");
    }

    public void showAllClasses() {
        List<WorkoutClass> classes = dao.getAllWorkoutClasses();
        for (WorkoutClass wc : classes) {
            System.out.println(wc);
        }
    }

    public void deleteClass(int id) {
        dao.deleteWorkoutClassById(id);
        System.out.println("❌ Workout class deleted.");
    }
}