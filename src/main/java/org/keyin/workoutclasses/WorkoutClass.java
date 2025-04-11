package org.keyin.workoutclasses;

public class WorkoutClass {
    private int id;
    private String type;
    private String description;
    private int trainerId;

    public WorkoutClass(int id, String type, String description, int trainerId) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.trainerId = trainerId;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getTrainerId() { return trainerId; }
    public void setTrainerId(int trainerId) { this.trainerId = trainerId; }

    @Override
    public String toString() {
        return "WorkoutClass{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", trainerId=" + trainerId +
                '}';
    }
}