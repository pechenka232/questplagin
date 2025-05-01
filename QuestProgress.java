package me.yourname.questmaster;

import java.util.HashMap;
import java.util.Map;

public class QuestProgress {
    private final Map<String, Integer> progress = new HashMap<>();

    public int getProgress(String questName) {
        return progress.getOrDefault(questName, 0);
    }

    public int addProgress(String questName) {
        int newVal = getProgress(questName) + 1;
        progress.put(questName, newVal);
        return newVal;
    }
}
