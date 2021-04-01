package de.nilsgamer.broadcaster.util;

import de.nilsgamer.broadcaster.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Broadcaster {
    private final long MESSAGE_DELAY = 25*20;
    private final String ROOT = "Broadcast Messages";

    private Main plugin;
    private FileConfiguration config;

    public Broadcaster(Main plugin) {
        this.plugin = plugin;
        config = plugin.getConfig();

        createDefaults();
    }
    public void startBroadcast(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', pickMessage()));

            }
        }, 0, MESSAGE_DELAY);
    }

    private void createDefaults(){
        if (config.contains(ROOT)) return;
        List<String> defaults = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            defaults.add("&cDeinen Nachricht Nr. " + i);
        config.set(ROOT, defaults);
        plugin.saveConfig();
    }
    private String pickMessage() {
        List<String> message = config.getStringList(ROOT);
        int random = new Random().nextInt(message.size());
        return message.get(random);
    }
}
