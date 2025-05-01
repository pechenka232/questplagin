package me.yourname.questmaster;

import me.yourname.questmaster.events.KillListener;
import org.bukkit.plugin.java.JavaPlugin;

public class QuestMaster extends JavaPlugin {

    private static QuestMaster instance;
    private QuestManager questManager;

    @Override
    public void onEnable() {
        instance = this;
        questManager = new QuestManager();
        getServer().getPluginManager().registerEvents(new KillListener(questManager), this);
        getCommand("quests").setExecutor((sender, command, label, args) -> {
            questManager.showQuests(sender);
            return true;
        });
        getLogger().info("QuestMaster enabled!");
    }

    public static QuestMaster getInstance() {
        return instance;
    }

    public QuestManager getQuestManager() {
        return questManager;
    }
}
