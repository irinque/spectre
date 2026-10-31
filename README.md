<div align="center">

# Spectre

### Hide player names above their heads and reveal them on right click

Keep overhead name tags out of view while still letting players identify each other when they choose.

</div>

---

## Key Features

- **Hidden name tags** — hide overhead player names for players who are online and those who join later.
- **Name on right click** — show the clicked player's name in the action bar when not sneaking.
- **Scoreboard cleanup** — restore a player's previous scoreboard when they leave or when Spectre shuts down.
- **bStats metrics** — collect standard server and plugin usage statistics.

---

## Functionality

Spectre hides player name tags using a scoreboard team. The plugin applies its scoreboard to players already online when it starts and to players as they join.

Right-click another player to see their name in your action bar. Sneak while clicking to suppress the message. Spectre does not cancel the interaction, so the server can still process the normal right-click action.

When a player leaves, Spectre restores the scoreboard they had before joining the plugin's team. It also restores the previous scoreboards of online players when the plugin is disabled.

---

## Requirements

- Minecraft server with API version `26.1` or newer.
- Java 25 or newer.

The Maven project uses Spigot API `26.1.1-R0.1-SNAPSHOT` and targets Java 25.

---

## Build and Install

Build the plugin with Maven:

```sh
mvn clean package
```

Copy `target/spectre-1.0-SNAPSHOT.jar` into the server's `plugins` directory and restart the server.

---

## Configuration

Spectre currently has no commands, permissions, or plugin-specific configuration file.

bStats can be disabled in the shared `plugins/bStats/config.yml` file by setting `enabled: false`.

---

Licensed under GPL-3.0. See [LICENSE](LICENSE).
