package me.irinque.spectre.handlers;

import me.irinque.spectre.loaders.PluginTeamLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnPlayerQuit implements Listener {
    private final PluginTeamLoader pluginTeam;

    public OnPlayerQuit(PluginTeamLoader pluginTeam) {
        this.pluginTeam = pluginTeam;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        pluginTeam.restorePlayer(event.getPlayer());
    }
}
