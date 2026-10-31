package me.irinque.spectre.handlers;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class OnPlayerClick implements Listener {

    @EventHandler
    public void onPlayerClick(PlayerInteractAtEntityEvent event) {
        if (event.getRightClicked() instanceof Player clickedPlayer && !event.getPlayer().isSneaking()) {
            event.getPlayer().spigot().sendMessage(
                    ChatMessageType.ACTION_BAR,
                    TextComponent.fromLegacyText(clickedPlayer.getName()));
        }
    }
}
