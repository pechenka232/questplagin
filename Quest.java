package me.yourname.questmaster;

public class Quest {
    private final String name;
    private final String description;
    private final String mobType;
    private final int targetCount;
    private final int reward;

    public Quest(String name, String description, String mobType, int targetCount, int reward) {
        this.name = name;
        this.description = description;
        this.mobType = mobType;
        this.targetCount = targetCount;
        this.reward = reward;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getMobType() { return mobType; }
    public int getTargetCount() { return targetCount; }
    public int getReward() { return reward; }
}
