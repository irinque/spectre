package me.irinque.spectre;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import me.irinque.spectre.handlers.OnPlayerClick;
import me.irinque.spectre.handlers.OnPlayerJoin;
import me.irinque.spectre.handlers.OnPlayerQuit;
import me.irinque.spectre.loaders.PluginTeamLoader;

public final class Spectre extends JavaPlugin {

    private PluginTeamLoader pluginTeam;
    private Metrics metrics;

    public PluginTeamLoader getTeam() {
        return pluginTeam;
    }

    @Override
    public void onEnable() {
        pluginTeam = new PluginTeamLoader();

        getServer().getPluginManager().registerEvents(new OnPlayerJoin(pluginTeam), this);
        getServer().getPluginManager().registerEvents(new OnPlayerQuit(pluginTeam), this);
        getServer().getPluginManager().registerEvents(new OnPlayerClick(), this);

        Bukkit.getOnlinePlayers().forEach(pluginTeam::addPlayer);

        metrics = new Metrics(this, 28387);
        getLogger().info("[Spectre] Plugin is ready");
    }

    @Override
    public void onDisable() {
        if (metrics != null) {
            metrics.shutdown();
        }
        if (pluginTeam != null) {
            pluginTeam.restorePlayers();
            pluginTeam.removeTeam();
        }
        getLogger().info("[Spectre] Plugin is off");
    }
}
