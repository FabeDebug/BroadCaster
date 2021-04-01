

import de.nilsgamer.broadcaster.util.Broadcaster;
import de.nilsgamer.broadcaster.util.info;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        //Console Message
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§6[BroadCaster] §cPlugin aktiviert");
        Bukkit.getConsoleSender().sendMessage("");
        new Broadcaster(this).startBroadcast();

    }

    @Override
    public void onDisable() {
        //Console Message
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§6[BroadCaster] §cPlugin deaktiviert");
        Bukkit.getConsoleSender().sendMessage("");
    }
}
