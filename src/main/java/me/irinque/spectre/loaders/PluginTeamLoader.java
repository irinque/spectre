package me.irinque.spectre.loaders;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import org.bukkit.scoreboard.Team.Option;
import org.bukkit.scoreboard.Team.OptionStatus;

public class PluginTeamLoader {
    private final Team pluginTeam;
    private final Scoreboard scoreboard;
    private final Map<UUID, Scoreboard> originalScoreboards = new HashMap<>();

    public PluginTeamLoader() {
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        scoreboard = scoreboardManager.getNewScoreboard();
        pluginTeam = scoreboard.registerNewTeam("SpectreTeam");
        pluginTeam.setCanSeeFriendlyInvisibles(false);
        pluginTeam.setOption(Option.NAME_TAG_VISIBILITY, OptionStatus.NEVER);
    }

    public void addPlayer(Player joinedPlayer) {
        originalScoreboards.putIfAbsent(joinedPlayer.getUniqueId(), joinedPlayer.getScoreboard());
        if (joinedPlayer.getScoreboard() != scoreboard) {
            joinedPlayer.setScoreboard(scoreboard);
        }
        pluginTeam.addEntry(joinedPlayer.getName());
    }

    public void restorePlayer(Player player) {
        Scoreboard originalScoreboard = originalScoreboards.remove(player.getUniqueId());
        pluginTeam.removeEntry(player.getName());
        if (originalScoreboard != null && player.getScoreboard() == scoreboard) {
            player.setScoreboard(originalScoreboard);
        }
    }

    public void restorePlayers() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            restorePlayer(player);
        }
    }

    public void removeTeam() {
        pluginTeam.unregister();
    }
}
