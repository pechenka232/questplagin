package me.yourname.questmaster;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

public class QuestManager {

    private final Map<UUID, QuestProgress> playerProgress = new HashMap<>();
    private final List<Quest> quests = new ArrayList<>();

    public QuestManager() {
        // Пример квеста: убить 5 зомби
        quests.add(new Quest("Охотник на зомби", "Убей 5 зомби", "ZOMBIE", 5, 100));
    }

    public void showQuests(CommandSender sender) {
        if (!(sender instanceof Player)) return;
        Player player = (Player) sender;

        player.sendMessage(ChatColor.GOLD + "=== Квесты ===");
        for (Quest q : quests) {
            QuestProgress progress = playerProgress.computeIfAbsent(player.getUniqueId(), uuid -> new QuestProgress());
            int done = progress.getProgress(q.getName());
            player.sendMessage(ChatColor.YELLOW + q.getName() + ": " + ChatColor.GREEN + done + "/" + q.getTargetCount());
        }
    }

    public void handleKill(Player player, String mobType) {
        for (Quest q : quests) {
            if (q.getMobType().equalsIgnoreCase(mobType)) {
                QuestProgress progress = playerProgress.computeIfAbsent(player.getUniqueId(), uuid -> new QuestProgress());
                int newCount = progress.addProgress(q.getName());
                if (newCount == q.getTargetCount()) {
                    player.sendMessage(ChatColor.AQUA + "Квест '" + q.getName() + "' завершён! + " + q.getReward() + " монет.");
                    // Тут можешь добавить экономику или награды
                }
            }
        }
    }
}
