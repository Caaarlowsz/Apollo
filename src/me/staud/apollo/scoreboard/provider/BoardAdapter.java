package me.staud.apollo.scoreboard.provider;

import org.bukkit.entity.Player;

import java.util.List;

public interface BoardAdapter {

    String getTitle(Player player);
    List<String> getScoreboard(Player player, Board board);
    List<String> getHeader();
    List<String> getFooter();
}
