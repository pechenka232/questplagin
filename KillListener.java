package me.yourname.questmaster.events;

import me.yourname.questmaster.QuestManager;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class KillListener implements Listener {

    private final QuestManager manager;

    public KillListener(QuestManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onMobKill(EntityDeathEvent event) {
        if (event.getEntity().getKiller() == null) return;
        Player player = event.getEntity().getKiller();
        EntityType type = event.getEntityType();
        manager.handleKill(player, type.name());
    }
}
