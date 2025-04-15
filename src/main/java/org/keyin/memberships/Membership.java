package org.keyin.memberships;

public class Membership {
    private int id;
    private String type;
    private String description;
    private double cost;
    private int memberId;

    public Membership(int id, String type, String description, double cost, int memberId) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.cost = cost;
        this.memberId = memberId;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }

    public int getMemberId() { return memberId; }
    public void setMemberId(int memberId) { this.memberId = memberId; }

    @Override
    public String toString() {
        return String.format(
            "💳 Membership ID: %d\n🏷️ Type: %s\n📝 Description: %s\n💰 Cost: $%.2f\n🙋 Member ID: %d\n",
            id, type, description, cost, memberId
        );
    }
}