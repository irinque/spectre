package me.irinque.spectre.handlers;

import me.irinque.spectre.loaders.PluginTeamLoader;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin implements Listener {
    private final PluginTeamLoader pluginTeam;

    public OnPlayerJoin(PluginTeamLoader pluginTeam) {
        this.pluginTeam = pluginTeam;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player joinedPlayer = event.getPlayer();
        pluginTeam.addPlayer(joinedPlayer);
    }
}
